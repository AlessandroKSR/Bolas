package com.dotsandboxes.game;

import java.util.Random;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 */
public class Main implements ApplicationListener {
    Grade celula;
    Bola bola;
    FitViewport viewport;
    Random random = new Random();

    @Override
    public void create() {
        celula = new Grade();
        bola = new Bola();
        bola.create();
        celula.create();
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
        
        celula.drawQuadrado(viewport, 1.5F, 1.5F);
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