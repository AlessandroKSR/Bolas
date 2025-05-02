package com.dotsandboxes.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Grade {
    private ShapeRenderer quadrado;
    private Boolean direita, esquerda, cima, baixo;
    private int ladosSelecionados;

    public void create() {
        quadrado = new ShapeRenderer();
    }

    public void drawQuadrado(FitViewport viewport, float coordenadaX, float coordenadaY) {
        quadrado.setProjectionMatrix(viewport.getCamera().combined);
        quadrado.begin(ShapeType.Filled);
        quadrado.setColor(Color.GOLD);
        quadrado.rect(coordenadaX, coordenadaY, 1, 1);
        quadrado.end();

        drawLine(viewport, coordenadaX, coordenadaY);
    }

    private void drawLine(FitViewport viewport, float coordenadaX, float coordenadaY) {
        Gdx.gl.glLineWidth(10);
        quadrado.setProjectionMatrix(viewport.getCamera().combined);
        quadrado.begin(ShapeType.Line);
        quadrado.setColor(Color.MAGENTA);
        quadrado.line(coordenadaX, coordenadaY, coordenadaX + 1, coordenadaY);
        quadrado.line(coordenadaX, coordenadaY, coordenadaX, coordenadaY + 1);
        quadrado.line(coordenadaX, coordenadaY + 1, coordenadaX + 1, coordenadaY + 1);
        quadrado.line(coordenadaX + 1, coordenadaY + 1, coordenadaX + 1, coordenadaY);
        quadrado.end();
    }

}