package com.dotsandboxes.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.ScreenUtils;

public class MenuInicial implements Screen {
    final Main game;
    Texture backgroundTexture;
    Music balatro;

    public MenuInicial(final Main game) {
        this.game = game;
        backgroundTexture = new Texture("balatro.png");
        balatro = Gdx.audio.newMusic(Gdx.files.internal("balatro.mp3"));
        balatro.setLooping(true);
    }

    @Override
    public void show() {
        balatro.play();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);

        game.viewport.apply();
        game.batch.setProjectionMatrix(game.viewport.getCamera().combined);

        game.batch.begin();
        game.batch.draw(backgroundTexture, 0, 0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
        // draw text. Remember that x and y are in meters
        game.font.draw(game.batch, "Welcome to Balatro!!!", game.viewport.getWorldWidth()/2 - new GlyphLayout(game.font, "Welcome to Balatro!!!").width/2, 1.5f);
        game.font.draw(game.batch, "Tap anywhere to begin!", game.viewport.getWorldWidth()/2 - new GlyphLayout(game.font, "Tap anywhere to begin!").width/2, 1);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new MenuJogo(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height, true);
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
