package com.dotsandboxes.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main implements ApplicationListener {
    Grid celula;
    FitViewport viewport;
    
    @Override
    public void create() {
        celula = new Grid();
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

    private void input(){

    }
    private void logic(){

    }
    private void draw(){
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        celula.quadrado.setProjectionMatrix(viewport.getCamera().combined);
        celula.quadrado.begin(ShapeType.Filled);
        celula.quadrado.rect(0, 0, 1, 1);
        celula.quadrado.setColor(Color.RED);
        celula.quadrado.end();
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