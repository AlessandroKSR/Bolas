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
    private ShapeRenderer quadrado;
    private Boolean direita, esquerda, cima, baixo, celulaDominada;
    private Rectangle[] colisorLinha;

    public void create() {
        celulaDominada = direita = esquerda = cima = baixo = false;
        quadrado = new ShapeRenderer();
        colisorLinha = new Rectangle[4];
        for (int i = 0; i < 4; i++) {
            colisorLinha[i] = new Rectangle(0, 0, 0.1f, 0.9f);
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
        quadrado.setColor(Color.MAGENTA);

        quadrado.line(coordenadaX, coordenadaY, coordenadaX + 1, coordenadaY);
        colisorLinha[0].setPosition(coordenadaX - 0.1f, coordenadaY + 0.1f);

        quadrado.line(coordenadaX, coordenadaY, coordenadaX, coordenadaY + 1);
        colisorLinha[1].setPosition(coordenadaX, coordenadaY + 1);
        colisorLinha[1].setSize(0.9f, 0.1f);

        quadrado.line(coordenadaX, coordenadaY + 1, coordenadaX + 1, coordenadaY + 1);
        colisorLinha[2].setPosition(coordenadaX, coordenadaY);
        colisorLinha[2].setSize(0.9f, 0.1f);

        quadrado.line(coordenadaX + 1, coordenadaY + 1, coordenadaX + 1, coordenadaY);
        colisorLinha[3].setPosition(coordenadaX + 0.95f, coordenadaY + 0.1f);
        quadrado.end();
    }

    public void mouseHover(Vector2 mousePos) {

        if (colisorLinha[0].contains(mousePos)) { // Direita
            if (direita == false) {
                quadrado.begin(ShapeType.Filled);
                quadrado.setColor(Color.RED);
                quadrado.rect(colisorLinha[0].x, colisorLinha[0].y - 0.2f, 0.2f, 1.2f);
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
                quadrado.rect(colisorLinha[1].x - 0.1f, colisorLinha[1].y - 0.1f, 1.2f, 0.2f);
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
                quadrado.rect(colisorLinha[2].x - 0.1f, colisorLinha[2].y - 0.1f, 1.2f, 0.2f);
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
                quadrado.rect(colisorLinha[3].x - 0.05f, colisorLinha[3].y - 0.2f, 0.2f, 1.2f);
                quadrado.end();

                if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    System.out.println("Esquerda");
                    esquerda = true;
                }
            }

        }
    }

    public int updateGrade() {
        if (direita && esquerda && cima && baixo) {
            celulaDominada = true;
            return 1;
        } else {
            return 0;
        }
    }

    private void desenharCelulaDominada() {
        if (celulaDominada == true) {
            System.out.println(celulaDominada);
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