package animals;

public class Dog extends Animal implements Jumpable {
    private final int RUN_LIMIT = 500;
    private final float JUMP_LIMIT = 5.5f;
    private float jump_limit;

    public Dog(String name) {
        this.name = name;
        this.run_limit = RUN_LIMIT;
        jump_limit = JUMP_LIMIT;
    }
    public Dog(String name, int run_limit, float jump_limit) {
        this.name = name;
        this.run_limit = run_limit;
        this.jump_limit = jump_limit;
    }

    @Override
    public boolean jump(float height) {
        return jump_limit >= height;
    }
    @Override
    public float getJumpLimit(){
        return jump_limit;
    }
}
