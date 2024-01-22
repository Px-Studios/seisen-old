package px.seisen;

public class GameStage {
    public double startTimestamp;
    public String stageName, stageId;

    public GameStage(String stageName, String stageId) {
        this.startTimestamp = System.currentTimeMillis();
        this.stageName = stageName;
        this.stageId = stageId;
    }

    public double getElapsedTime() {
        return System.currentTimeMillis() - this.startTimestamp;
    }
}
