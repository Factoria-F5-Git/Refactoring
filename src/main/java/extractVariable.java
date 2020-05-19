class Window {

    public String platform;
    public String browser;
    public Boolean initialised;
    public Integer resize;

    Window(String platform, String browser, Boolean initialised, Integer resize) {
        this.platform = platform;
        this.browser = browser;
        this.initialised = initialised;
        this.resize = resize;
    }

    String renderBanner() {
        if ((platform.toUpperCase().indexOf("MAC") > -1) &&
                (browser.toUpperCase().indexOf("IE") > -1) &&
                initialised && resize > 0) {
            return "Resized banner rendered!";
        } else {
            return "";
        }
    }
}
