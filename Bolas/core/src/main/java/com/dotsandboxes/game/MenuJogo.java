package com.dotsandboxes.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

public class MenuJogo implements Screen{
    final Main game;
    Grade[] celulas;
    Bola bolas;
    Mouse myMouse;

    public MenuJogo(final Main game) {
        this.game = game;
        celulas = new Grade[25];
        myMouse = new Mouse();
        bolas = new Bola();
        bolas.create();
        for(int i = 0; i < 25; i++)
        {
            celulas[i] = new Grade();
            celulas[i].create();
        }

        game.viewport.getCamera().position.set(4, 4, 0);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        draw();
        logic();
        bolas.criarGrade();
    }

    private void logic() {
        myMouse.setMousePosition(game.viewport);
        for(int i = 0; i < 25; i++) {
            celulas[i].mouseHover(myMouse.getMousePosicao());
            celulas[i].updateGrade();
        }
        
    }

    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        game.viewport.apply();

        celulas[0].setContadorGrade(0);
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                celulas[celulas[0].getContadorGrade()].drawQuadrado(game.viewport, j + 1.5f, i + 1.5f);
                celulas[0].updateContadorGrade();
            }
        }
        
    }

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }
    
}
