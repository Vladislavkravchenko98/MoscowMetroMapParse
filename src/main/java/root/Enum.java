package root;

public enum Enum {
    sokolnicheskayalinija("1"),
    zamoskvoretskayalinija("2"),
    arbatskopokrovskayalinija("3"),
    filevskayalinija("4"),
    koltsevayalinija("5"),
    kalujskorijskayalinija("6"),
    taganskokrasnopresnenskayalinija("7"),
    kalininskosolntcevskayalinija("8"),
    serpukhovskotimiryazevskayalinija("9"),
    lyublinskodmitrovskayalinija("10"),
    tpk("11"),
    kakhovskayalinija("11A"),
    butovskayalinija("12"),
    mck("14"),
    nekrasovskaya("15"),
    mcd1("D1"),
    mcd2("D2");

    private String translation;

    Enum(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}
