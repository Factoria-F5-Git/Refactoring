class Window {

    private String platform;
    private String browser;
    private Boolean initialised;
    private Integer resize;

    Window(String platform, String browser, Boolean initialised, Integer resize) {
        this.platform = platform;
        this.browser = browser;
        this.initialised = initialised;
        this.resize = resize;
    }

    String renderBanner() {
        //better method than IndexOf?
        if ((platform.toUpperCase().indexOf("MAC") > -1) &&
                (browser.toUpperCase().indexOf("IE") > -1) &&
                initialised && resize > 0) {
            //any refactoring here?
            return "Resized banner rendered!";
        } else {
            return "";
        }
    }
}
