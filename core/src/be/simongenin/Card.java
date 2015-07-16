package be.simongenin;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.List;

public class Card {

    // Info
    private String name;
    private List<Attribut> attributs;

    // Graphics
    private CardSprite sprite;
    private Texture faceUpTexture;
    private Texture faceDownTexture;

    // Animation
    private boolean isFlipping;
    private boolean hasSwappedTexture;
    private final int flipSpeed = Config.CARD_ANIMATION_FLIP_SPEED; //pre : % 2 == 0

    // State
    private CardFace cardFace;
    private int lifePoints;
    private int strengthPoints;
    private int cost;

    public Card (String name, List<Attribut> attributs, Texture texture, int cost, int life, int strength) {
        this.name = name;
        this.attributs = attributs;
        this.cost = cost;
        lifePoints = life;
        strengthPoints = strength;
        faceUpTexture = texture;
        faceDownTexture = TextureUtils.BACK_TEXTURE;
        sprite = new CardSprite();
        setFace(CardFace.FACE_UP);
    }

    /**
     * Render a card
     */
    public void render(SpriteBatch batch) {

        // If card is flipping, let it continue
        if (isFlipping)
            flip();

        sprite.render(batch);
    }

    /**
     * Flip a card
     */
    public void flip() {

        isFlipping = true;

        // Modify the width
        if (!hasSwappedTexture) {
            sprite.width -= flipSpeed;
            sprite.x += flipSpeed / 2;
        } else {
            sprite.width += flipSpeed;
            sprite.x -= flipSpeed / 2;
        }

        // Change the texture when width == 0
        if (sprite.width <= 0) {
            sprite.width = 0;
            setFace((cardFace == CardFace.FACE_UP) ? CardFace.FACE_DOWN : CardFace.FACE_UP);
            hasSwappedTexture = true;
        }

        // When flip is over
        if (sprite.width >= Config.CARD_WIDTH && hasSwappedTexture) {
            sprite.width = Config.CARD_WIDTH;
            hasSwappedTexture = false;
            isFlipping = false;
        }

    }

    /**
     * Set the face of the cards
     * Handle the sprite texture
     */
    public void setFace(CardFace face) {
        if (face == CardFace.FACE_DOWN) {
            cardFace = CardFace.FACE_DOWN;
            sprite.texture = faceDownTexture;
        } else {
            cardFace = CardFace.FACE_UP;
            sprite.texture = faceUpTexture;
        }
    }
}
