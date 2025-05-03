package com.dotsandboxes.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Mouse {
    private Vector2 mousePosicao;
    
    public Mouse(){
        mousePosicao = new Vector2(0,0);
    }

    public void setMousePosition(FitViewport viewport)
    {
        mousePosicao.set(Gdx.input.getX(), Gdx.input.getY());
        viewport.unproject(mousePosicao);
    }

    public Vector2 getMousePosicao() {
        return mousePosicao;
    }
}