/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmeticcoding;

/**
 *
 * @author Edward
 */
public class ArithmeticCoding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArithmeticCoder arithmeticCoder = new ArithmeticCoder();

//        String string ="ABCDEFGHIJKLMNOPQRSTUVWXYZ ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        String string ="BILL GATES";
        String string = "Transmission:less network bandwidth can be used, by compressing data at the sending end and decompressing data at the receiving end.";
//        String string = "a dl jar g'o adg 'arg#rg a#[dfg]ar adfg#[ o#[adg'pjdf  p'fgopadfsdfga dl jar g'o adg 'arg#rg a#[dfg]ar adfg#[ o#[adg'pjdf  p'fgopadfsdfga dl jar g'o adg 'arg#rg a#[dfg]ar adfg#[ o#[adg'pjdf  p'fgopadfsdfga dl jar g'o adg 'arg#rg a#[dfg]ar adfg#[ o#[adg'pjdf  p'fgopadfsdfga dl jar g'o adg 'arg#rg a#[dfg]ar adfg#[ o#[adg'pjdf  p'fgopadfsdfga dl jar g'o adg 'arg#rg a#[dfg]ar adfg#[ o#[adg'pjdf  p'fgopadfsdfga dl jar g'o adg 'arg#rg a#[dfg]ar adfg#[ o#[adg'pjdf  p'fgopadfsdfg";

//        String string = "The daughter of Herbert Bernard and Ethel Anne Feilman (née Turner),[2] Feilman grew up in the Southwest Region of Western Australia. In 1938 she became the first female cadet in the Public Works Department of Western Australia, and completed a Bachelor of Arts degree at the University of Western Australia in 1943. Studying at Perth Technical College,[2] she passed the Final Examination for Registration as an Architect in 1945. She received a British Council scholarship in 1948.[3] In 1950 she completed her Postgraduate Diploma in Town Planning at the School of Town and Country Planning at the University of Durham, after which she returned to Perth and opened a practice in architecture and town planning. In 1952, for the state Public Works Department, she planned the townsite of Kwinana New Town, to house 25,000 industry employees.[4]\n"
//                + "\n"
//                + "A founding member of the Western Australian branch of the National Trust of Australia[5] in 1959, she later became an inaugural Commissioner on the Australian Heritage Commission in 1976, played a role in setting up the Register of the National Estate and supported the introduction of Heritage Conservation Studies in Australian universities. She was also involved in public comment about the various changes in heritage legislation [6]";
        EncodedString results = arithmeticCoder.encode(string);
        String outputString = arithmeticCoder.decode(results);
        System.out.println("equal?:" + (outputString.equalsIgnoreCase(string)) + " output:" + outputString + "|" + "input :" + string + "|");
        System.out.println(results.getStringLow());
//        for (int i = 1; i < 53; i++) {
////            System.out.println("#############################");
//            EncodedString results = arithmeticCoder.encode(string.substring(0, i));
////            System.out.println("input :"+string.substring(0, i) + "|");
//            String outputString = arithmeticCoder.decode(results);
////            System.out.println("output:"+outputString + "|");
////            System.out.println("encoded string :"+results.getStringLow());
////            System.out.println("equal?:"+(outputString.equalsIgnoreCase(string.substring(0, i))));
//            System.out.println("equal?:" + (outputString.equalsIgnoreCase(string.substring(0, i))) + " output:" + outputString + "|" + "input :" + string.substring(0, i) + "|");
//        }
//        System.out.println(string.length());

    }

}
