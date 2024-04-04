package model.vo;

public class LottoBall {
    private final int number;

    public LottoBall(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBall lottoBall = (LottoBall) o;
        return number == lottoBall.number;
    }

    public int getNumber() {
        return number;
    }
}
