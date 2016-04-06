public class Base64Encode
{
    private static final char[] map = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };

    public static String encode(String stringCode){

    byte[] sourceByte = stringCode.getBytes();
    StringBuffer encodeBuffer = new StringBuffer();
    int len = sourceByte.length;
    int position = 0;

    for(position = 0; position < len; position+=3 ){
        int c = 0xFF & sourceByte[position];
        if( position + 1 == len ){
            encodeBuffer.append(map[(c >>> 2)]);
            encodeBuffer.append(map[(c & 0x3 ) << 4]);
            encodeBuffer.append("==");
            break;
        }

        if( position + 2 == len ){
            int cNext = 0xFF & sourceByte[position+1];
            encodeBuffer.append(map[(c >>> 2)]);
            encodeBuffer.append(map[((c & 0x3) << 4) | ((cNext & 0xF0) >>> 4)]);
            encodeBuffer.append(map[(cNext & 0xF) << 2]);
            encodeBuffer.append("=");
            break;
        }

        int cNext = 0xFF & sourceByte[position+1];
        int cThird = 0xFF & sourceByte[position+2];

        encodeBuffer.append(map[(c >>> 2)]);
        encodeBuffer.append(map[((c & 0x3) << 4 | (cNext & 0xF0) >>> 4)]);
        encodeBuffer.append(map[((cNext & 0xF) << 2 | (cThird & 0xC0) >>> 6)]);
        encodeBuffer.append(map[(cThird & 0x3F)]);
    }

    return encodeBuffer.toString();
  }
}
