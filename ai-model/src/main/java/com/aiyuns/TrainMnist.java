package com.aiyuns;

import ai.djl.Model;
import ai.djl.basicdataset.cv.classification.Mnist;
import ai.djl.ndarray.NDArray;
import ai.djl.ndarray.NDList;
import ai.djl.training.Trainer;
import ai.djl.training.dataset.Batch;
import ai.djl.training.dataset.RandomAccessDataset;
import ai.djl.training.tracker.Tracker;
import ai.djl.translate.TranslateException;
import ai.djl.training.loss.Loss;
import ai.djl.training.util.ProgressBar;
import ai.djl.training.optimizer.Optimizer;
import ai.djl.training.listener.TrainingListener;
import ai.djl.training.DefaultTrainingConfig;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TrainMnist {

    public static void main(String[] args) throws IOException, TranslateException {
        // 使用自定义的 MLP 模型
        Model model = MlpModel.createModel();

        // 准备训练数据集
        Mnist trainDataset = Mnist.builder()
                .optUsage(RandomAccessDataset.Usage.TRAIN)
                .setSampling(32, true)  // Batch size: 32
                .build();
        trainDataset.prepare(new ProgressBar());

        // 准备测试数据集
        Mnist testDataset = Mnist.builder()
                .optUsage(RandomAccessDataset.Usage.TEST)
                .setSampling(32, true)
                .build();
        testDataset.prepare(new ProgressBar());

        // 定义训练配置，包括优化器和学习率跟踪器
        DefaultTrainingConfig config = new DefaultTrainingConfig(Loss.softmaxCrossEntropyLoss())
                .optOptimizer(Optimizer.sgd()
                        .setLearningRateTracker(Tracker.fixed(0.01f)) // 设置固定学习率为 0.01
                        .build()) // 使用 SGD 优化器
                .addTrainingListeners(TrainingListener.Defaults.logging()); // 添加日志监听器

        try (Trainer trainer = model.newTrainer(config)) {
            trainer.initialize(new ai.djl.ndarray.types.Shape(32, 28 * 28));  // 输入数据的形状

            // 训练循环
            for (int epoch = 0; epoch < 5; epoch++) {  // 训练 5 个 epoch
                System.out.println("Epoch " + (epoch + 1));

                for (Batch batch : trainer.iterateDataset(trainDataset)) {
                    // 1. 正向传播 (forward)
                    NDArray data = batch.getData().get(0).reshape(new ai.djl.ndarray.types.Shape(32, 28 * 28));  // 32是批大小
                    NDArray labels = batch.getLabels().get(0);

                    // 传入数据进行前向计算
                    NDList predictions = trainer.forward(new NDList(data));

                    // 2. 计算损失
                    NDArray lossValue = trainer.getLoss().evaluate(new NDList(labels), predictions).get(0);  // 获取 NDList 的第一个元素
                    float lossScalar = lossValue.getFloat();  // 获取标量值

                    System.out.println("Loss: " + lossScalar);

                    // 3. 反向传播 (DJL会在内部处理)
                    trainer.step();

                    // 清理当前 batch 的资源
                    batch.close();
                }

                System.out.println("Epoch " + (epoch + 1) + " complete.");
            }

            // 构建保存到桌面的路径
            Path desktopPath = Paths.get(System.getProperty("user.home"), "Desktop", "mlp-model");

            // 保存模型到桌面
            model.save(desktopPath, "mlp");

            System.out.println("Model saved to: " + desktopPath.toString());
        }
    }
}