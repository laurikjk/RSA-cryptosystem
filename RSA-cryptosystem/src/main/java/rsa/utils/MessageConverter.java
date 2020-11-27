package rsa.utils;

import java.math.BigInteger;

/**
 * Convert messages to Big integer for RSA
 */
public class MessageConverter {

    /**
     *
     * @param message as a string
     * @return message as a big integer
     */
    public BigInteger convertString(String message) {
        byte[] messageAsBytes = message.getBytes();
        StringBuilder stringBuilder = new StringBuilder();

        for(byte b : messageAsBytes){
            String toBeAppended = Integer.toString(b);
            if (toBeAppended.length()==2){
                toBeAppended="00"+toBeAppended;
            } else {
                toBeAppended="0"+toBeAppended;
            }

            stringBuilder.append(toBeAppended);
        }

        BigInteger convertedMessage = new BigInteger(stringBuilder.toString());
        return convertedMessage;
    }

    /**
     *
     * @param message as a big integer
     * @return message as a string
     */
    public String convertBigInteger(BigInteger message) {
        String convertedMessage = message.toString();
        convertedMessage = addZerosToBeginning(convertedMessage);
        StringBuilder result = new StringBuilder();

        for (int i = 3; i < convertedMessage.length(); i+=4){
            StringBuilder sb = new StringBuilder();
            for (int j = 3; j >=0; j--){
                sb.append(convertedMessage.charAt(i-j));
            }
            int asciiCode = Integer.valueOf(sb.toString());
            result.append((char) asciiCode);
        }

        return result.toString();


    }

    /**
     * 
     *
     * @param messageToAddZeros
     * @return message with zeros added to the beginning
     */
    private String addZerosToBeginning(String messageToAddZeros){
        char zero = "0".charAt(0);
        if (messageToAddZeros.length() == 2){
            messageToAddZeros="00"+messageToAddZeros;
        } else if (messageToAddZeros.length() == 3){
            messageToAddZeros="0"+messageToAddZeros;
        } else {
            int firstZero = 0;
            for (int i = 0; i < 4; i++){
                if (messageToAddZeros.charAt(i) == zero) {
                    firstZero=i;
                    break;
                }
            }
            if (firstZero == 2){
                messageToAddZeros="00"+messageToAddZeros;
            } else {
                messageToAddZeros="0"+messageToAddZeros;
            }
        }

        return messageToAddZeros;

    }

}


