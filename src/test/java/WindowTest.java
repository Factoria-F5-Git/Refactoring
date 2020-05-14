import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WindowTest {
    private Window window;

    @Test
    public void renderBannerIsRenderedWhenPlatformIsMacAndBrowserIsIEAndIsInitialisedAndIsResized(){
        window = new Window("MAC", "IE", true, 3);

        assertEquals(window.renderBanner(),"Resized banner rendered!");
    }

}