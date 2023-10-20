package Model;

public enum ContentState {
    ARCHIVED("Archived"),
    SHOWED("Showed"),
    DELETED("Deleted"),
    PINNED("Pinned");

    private String STATUS;

    public String getSTATUS() {
        return STATUS;
    }

    private ContentState(String s) {
        this.STATUS = s;
    }
}
