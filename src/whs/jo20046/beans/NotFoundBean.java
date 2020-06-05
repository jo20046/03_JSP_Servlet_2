package whs.jo20046.beans;

public class NotFoundBean {

    String[] notFoundTexts = new String[3];

    public NotFoundBean() {
        for (int i = 0, notFoundTextsLength = notFoundTexts.length; i < notFoundTextsLength; i++) {
            setNotFoundText(i, "");
        }
    }

    public String[] getNotFoundTexts() {
        return notFoundTexts;
    }

    public void setNotFoundTexts(String[] notFoundTexts) {
        this.notFoundTexts = notFoundTexts;
    }

    public String getNotFoundText(int index) {
        return index >= 0 && index < notFoundTexts.length ? notFoundTexts[index] : "Index " + index + " out of bounds";
    }

    public boolean setNotFoundText(int index, String newValue) {
        if (index >= 0 && index < notFoundTexts.length) {
            notFoundTexts[index] = newValue;
            return true;
        }
        return false;
    }
}
