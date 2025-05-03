package com.dotsandboxes.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Main implements ApplicationListener {
    Grade[] celulas;
    Bola bolas;
    FitViewport viewport;
    Mouse myMouse;

    @Override
    public void create() {
        celulas = new Grade[25];
        myMouse = new Mouse();
        bolas = new Bola();
        bolas.create();
        for(int i = 0; i < 25; i++)
        {
            celulas[i] = new Grade();
            celulas[i].create();
        }

        viewport = new FitViewport(8, 8);
        viewport.getCamera().position.set(4, 4, 0);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void render() {
        draw();
        logic();
        bolas.criarGrade();
    }

    private void logic() {
        myMouse.setMousePosition(viewport);
        for(int i = 0; i < 25; i++) {
            celulas[i].mouseHover(myMouse.getMousePosicao());
        }
        
    }

    
    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();

        celulas[0].setContadorGrade(0);
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                celulas[celulas[0].getContadorGrade()].drawQuadrado(viewport, j + 1.5f, i + 1.5f);
                celulas[0].updateContadorGrade();
            }
        }
        
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}