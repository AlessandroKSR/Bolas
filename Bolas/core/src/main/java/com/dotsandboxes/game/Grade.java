package com.dotsandboxes.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Grade {
    private static int contatadorGrade = 0;
    private static float colisorLinhaHorizontalWidth = 0.5f, colisorLinhaHorizontalHeight = 0.2f,
            colisorLinhaVerticalHeight = 0.5f, colisorLinhaVerticalWidth = 0.2f;
    private ShapeRenderer quadrado;
    private Boolean direita, esquerda, cima, baixo, celulaDominada;
    private Rectangle[] colisorLinha;

    public void create() {
        celulaDominada = direita = esquerda = cima = baixo = false;
        quadrado = new ShapeRenderer();
        colisorLinha = new Rectangle[4];
        for (int i = 0; i < 4; i++) {
            colisorLinha[i] = new Rectangle(0, 0, colisorLinhaVerticalWidth, colisorLinhaVerticalHeight);
        }
    }

    public void drawQuadrado(FitViewport viewport, float coordenadaX, float coordenadaY) {
        quadrado.setProjectionMatrix(viewport.getCamera().combined);
        quadrado.begin(ShapeType.Filled);
        desenharCelulaDominada();
        quadrado.rect(coordenadaX, coordenadaY, 1, 1);
        quadrado.end();
        drawLine(viewport, coordenadaX, coordenadaY);
    }

    private void drawLine(FitViewport viewport, float coordenadaX, float coordenadaY) {
        Gdx.gl.glLineWidth(10);
        quadrado.setProjectionMatrix(viewport.getCamera().combined);
        quadrado.begin(ShapeType.Line);
        quadrado.setColor(Color.GRAY);

        quadrado.line(coordenadaX, coordenadaY, coordenadaX + 1, coordenadaY); // Direita
        colisorLinha[0].setPosition(coordenadaX + 0.9f, coordenadaY + 0.25f);

        quadrado.line(coordenadaX, coordenadaY, coordenadaX, coordenadaY + 1); // Cima
        colisorLinha[1].setPosition(coordenadaX + 0.25f, coordenadaY + 0.9f);
        colisorLinha[1].setSize(colisorLinhaHorizontalWidth, colisorLinhaHorizontalHeight);

        quadrado.line(coordenadaX, coordenadaY + 1, coordenadaX + 1, coordenadaY + 1); // Baixo
        colisorLinha[2].setPosition(coordenadaX + 0.25f, coordenadaY - 0.1f);
        colisorLinha[2].setSize(colisorLinhaHorizontalWidth, colisorLinhaHorizontalHeight);

        quadrado.line(coordenadaX + 1, coordenadaY + 1, coordenadaX + 1, coordenadaY); // Esquerda
        colisorLinha[3].setPosition(coordenadaX - 0.1f, coordenadaY + 0.25f);
        quadrado.end();
    }

    public void mouseHover(Vector2 mousePos) {

        if (colisorLinha[0].contains(mousePos)) { // Direita
            if (direita == false) {
                quadrado.begin(ShapeType.Filled);
                quadrado.setColor(Color.RED);
                quadrado.rect(colisorLinha[0].x, colisorLinha[0].y - 0.35f, 0.2f, 1.2f);
                quadrado.end();

                if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    direita = true;
                    System.out.println("Direita");
                }
            }
        }

        if (colisorLinha[1].contains(mousePos)) { // Cima
            if (cima == false) {
                quadrado.begin(ShapeType.Filled);
                quadrado.setColor(Color.RED);
                quadrado.rect(colisorLinha[1].x - 0.35f, colisorLinha[1].y, 1.2f, 0.2f);
                quadrado.end();

                if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    cima = true;
                }
            }
        }

        if (colisorLinha[2].contains(mousePos)) { // Baixo
            if (baixo == false) {
                quadrado.begin(ShapeType.Filled);
                quadrado.setColor(Color.RED);
                quadrado.rect(colisorLinha[2].x - 0.35f, colisorLinha[2].y, 1.2f, 0.2f);
                quadrado.end();

                if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    baixo = true;
                }
            }

        }

        if (colisorLinha[3].contains(mousePos)) { // Esquerda
            if (esquerda == false) {
                quadrado.begin(ShapeType.Filled);
                quadrado.setColor(Color.RED);
                quadrado.rect(colisorLinha[3].x, colisorLinha[3].y - 0.35f, 0.2f, 1.2f);
                quadrado.end();

                if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    System.out.println("Esquerda");
                    esquerda = true;
                }
            }

        }
    }

    public boolean updateGrade() {
        if (direita && esquerda && cima && baixo) {
            celulaDominada = true;
            return true;
        } else {
            return false;
        }
    }

    public void updateBordas() {
        if (direita == true) {
            quadrado.begin(ShapeType.Filled);
            quadrado.setColor(Color.NAVY);
            quadrado.rect(colisorLinha[0].x, colisorLinha[0].y - 0.35f, 0.2f, 1.2f);
            quadrado.end();
        }
        if (cima == true) {
            quadrado.begin(ShapeType.Filled);
            quadrado.setColor(Color.NAVY);
            quadrado.rect(colisorLinha[1].x - 0.35f, colisorLinha[1].y, 1.2f, 0.2f);
            quadrado.end();
        }
        if (baixo == true) {
            quadrado.begin(ShapeType.Filled);
            quadrado.setColor(Color.NAVY);
            quadrado.rect(colisorLinha[2].x - 0.35f, colisorLinha[2].y, 1.2f, 0.2f);
            quadrado.end();
        }
        if (esquerda == true) {
            quadrado.begin(ShapeType.Filled);
            quadrado.setColor(Color.NAVY);
            quadrado.rect(colisorLinha[3].x, colisorLinha[3].y - 0.35f, 0.2f, 1.2f);
            quadrado.end();
        }
    }

    private void desenharCelulaDominada() {
        if (celulaDominada == true) {
            quadrado.setColor(Color.BLUE);
        } else {
            quadrado.setColor(Color.BLACK);
        }
    }

    public void updateContadorGrade() {
        contatadorGrade++;
    }

    public int getContadorGrade() {
        return contatadorGrade;
    }

    public void setContadorGrade(int input) {
        contatadorGrade = input;
    }

}