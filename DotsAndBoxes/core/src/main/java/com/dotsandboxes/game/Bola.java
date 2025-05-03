package com.dotsandboxes.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Bola {
    public ShapeRenderer circulo;

    public void create() {
        circulo = new ShapeRenderer();
    }

    public void criarGrade() {
        circulo.begin(ShapeType.Filled);
        circulo.setColor(Color.WHITE);
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                circulo.circle((j * 100) + 150, (i * 100) + 150, 15);
            }
        }

        circulo.end();
    }

}