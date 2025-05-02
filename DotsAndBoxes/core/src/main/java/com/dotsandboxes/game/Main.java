package com.dotsandboxes.game;

import java.util.Random;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 */
public class Main implements ApplicationListener {
    Grade[] celulas;
    Bola bola;
    FitViewport viewport;
    Random random = new Random();

    @Override
    public void create() {
        celulas = new Grade[25];
        bola = new Bola();
        bola.create();

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
        // Resize your application here. The parameters represent the new window size.
        viewport.update(width, height);
    }

    @Override
    public void render() {
        draw();
    }

    private void input() {

    }

    private void logic() {

    }

    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5;j++)
            {
                celulas[j].drawQuadrado(viewport, 1.5F + j, 1.5F + i);;
            }

            
        }
       
        bola.criarGrade(random);
        
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void dispose() {
        // Destroy application's resources here.
    }
}