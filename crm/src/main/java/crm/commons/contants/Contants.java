package crm.commons.contants;

public enum Contants {
    CODE("1","0", ""),
    SESSION("","","sessionUser");

    private final String success ;
    private final String fail ;
    private final String value;

    public String getValue() {
        return value;
    }

    private Contants(String success, String fail, String value) {
        this.success = success;
        this.fail = fail;
        this.value = value;
    }

    public String getSuccess() {
        return success;
    }

    public String getFail() {
        return fail;
    }
}
