package com.aiyuns;

import ai.djl.Model;
import ai.djl.nn.Activation;
import ai.djl.nn.Block;
import ai.djl.nn.SequentialBlock;
import ai.djl.nn.core.Linear;

public class MlpModel {

    public static Model createModel() {
        // 定义一个SequentialBlock（顺序模型）
        Block mlpBlock = new SequentialBlock()
                // 输入层：28 * 28 -> 128
                .add(Linear.builder().setUnits(128).build())
                .add(Activation.reluBlock())
                // 隐藏层：128 -> 64
                .add(Linear.builder().setUnits(64).build())
                .add(Activation.reluBlock())
                // 输出层：64 -> 10 (对应10个类别的输出)
                .add(Linear.builder().setUnits(10).build());

        // 创建模型并设置Block
        Model model = Model.newInstance("mlp");
        model.setBlock(mlpBlock);

        return model;
    }
}
