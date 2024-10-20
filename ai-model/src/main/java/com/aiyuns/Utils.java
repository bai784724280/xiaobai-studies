package com.aiyuns;

import ai.djl.training.DefaultTrainingConfig;
import ai.djl.training.TrainingConfig;
import ai.djl.training.listener.TrainingListener;
import ai.djl.training.loss.Loss;
import ai.djl.training.optimizer.Optimizer;
import ai.djl.training.tracker.Tracker;

public class Utils {
    public static TrainingConfig getTrainingConfig() {
        // 配置损失函数和优化器
        return new DefaultTrainingConfig(Loss.softmaxCrossEntropyLoss())
                .optOptimizer(Optimizer.sgd().setLearningRateTracker(Tracker.fixed(0.1f)).build())
                .addTrainingListeners(TrainingListener.Defaults.logging());
    }
}
