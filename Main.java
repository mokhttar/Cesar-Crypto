public class Main {

    public static void main(String[] arg) {
        String message = "tarelcgxbaowt.cfotafhetogwtofputglobuoftafxgxitoxaube pgxbanotiteloftrheto tffpvtoet.xtfobaotuutrgxitop.vbexgw fopasoztlo papvt tagogbocebgtrgospgpoueb ohaphgwbexmtsoprrtffn";
        Cesar cesar = new Cesar(message);
        char[] Alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '.', ' ' };
        // System.out.println(cesar.CalculateOccurences(message));
        // System.out.println(cesar.maxCharacter(message,
        // Alphabet,cesar.CalculateOccurences(message)));
        cesar.Decrypt(message, cesar.maxCharacter(message, Alphabet, cesar.CalculateOccurences(message)), Alphabet);
    }

}