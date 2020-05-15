import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WindowTest {
    private Window window;

    @Test
    public void renderBannerIsRenderedWhenPlatformIsMacAndBrowserIsIEAndIsInitialisedAndIsResized(){
        window = new Window("MAC", "IE", true, 3);

        assertEquals("Resized banner rendered!", window.renderBanner());
    }

    @Test
    public void renderEmptyStringWhenPlatformIsWindows() {
        window = new Window("Windows", "IE", true, 3);

        assertEquals("", window.renderBanner());
    }

}
