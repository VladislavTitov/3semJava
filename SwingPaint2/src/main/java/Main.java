public class Main {
    public static void main(String[] args) {
        ColorChooser chooser = ColorChooser.createAndShowGUI();
        DrawFrame drawFrame = new DrawFrame(chooser);
    }
}
