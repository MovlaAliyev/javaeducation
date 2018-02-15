/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import db.GetConfigLists;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nhumbatova
 */
public class LineValidation {

    /*List<String> currencyList = Arrays.asList("AED", "AMD", "AOA", "ARS", "AUD", "AZN", "BAM", "BGN", "BHD", "BRL", 
     "BYN", "BYR", "CAD", "CHF", "CNY", "COP", "CRC", "CZK", "DJF", "DKK",
     "DOP", "EEK", "EGP", "ETB", "EUR", "GBP", "GEL", "HKD", "HRK", "HUF",
     "IDR", "ILS", "INR", "IRR", "ISK", "JMD", "JOD", "JPY", "KES", "KGS",
     "KRW", "KWD", "KZT", "LBP", "LKR", "LTL", "LVL", "MAD", "MDL", "MKD",
     "MNT", "MOP", "MUR", "MXN", "MYR", "NAD", "NOK", "NPR", "NZD", "OMR",
     "PHP", "PKR", "PLN", "QAR", "RON", "RSD", "RUB", "RUR", "SAR", "SCR",
     "SEK", "SGD", "THB", "TJS", "TMT", "TND", "TRY", "TWD", "UAE", "UAH",
     "USD", "UZS", "VND", "XAG", "XAU", "XPD", "XPF", "XPT", "ZAR", "ZMW");
     List<String> pTypeList = Arrays.asList("S", "T", "U");
     List<String> paymentBudgetLevelList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "1Y", "2Y", "3Y", "4Y", "5Y", "6Y", "7Y");
     List<String> pSalTypeList = Arrays.asList("EH", "SHH", "AMH", "AV", "BN", "MKF", "MZN", "TQD", "MY", "DG", "YSH", "XH", "BP", "EZM", "KMP");*/
    List<String> currencyList;
    List<String> pTypeList;
    List<String> paymentBudgetLevelList;
    List<String> pSalTypeList;

    public LineValidation() {
        GetConfigLists conf = new GetConfigLists();

        try {
            currencyList = conf.getConfigSingle("CCY");
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        try {
            pTypeList = conf.getConfigSingle("PTYPE");
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        try {
            paymentBudgetLevelList = conf.getConfigSingle("BL");
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        try {
            pSalTypeList = conf.getConfigSingle("SALTYPE");
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public String validateLine(String line, int lineNum, String file_type) {
        String err = "";

        if (isBlank((line.replaceAll(",", "")).trim())) {
            err = "Sətr:" + lineNum + " :: Sətr boşdu.<br/>";
            return err;
        }

        String[] params = line.split(",", -1);
        //System.out.println("Len="+ params.length + "  "+ line);

        if ("P".equals(file_type)) {
            String payMthd = (params[0].trim()).replaceAll("\"", "");

            switch (payMthd) {
                case "IN":
                    err += validateInternalPayment(params, lineNum);
                    break;
                case "DM":
                    err += validateDomesticPayment(params, lineNum);
                    break;
                case "IT":
                    err += validateInternationalPayment(params, lineNum);
                    break;
                default:
                    System.out.println("payMthd=" + payMthd);
                    err += "Sətr:" + lineNum + " :: Yanlış köçürmə tipi:  Xahiş olunur seçim edəsiniz: DM, IT, IN.<br/>";
                    break;
            }
        } else if ("S".equals(file_type)) {
            err += validateSalaryPayment(params, lineNum);
        } else {
            err += "Unknown file type. <br/>";
        }

        return err;
    }

    public String validateInternalPayment(String[] params, int lineNum) {
        String err = "";
        String pMethod;
        String pAccount = "";
        String accCCY;
        String pDate;
        String pCCY;
        String pBenAcc;
        String pAmount;
        String pDesc;

        int paramCount;

        boolean isOK;

        paramCount = getLength(params);
        if (paramCount < 7) {
            err += "Sətr:" + lineNum + " :: Yanlış köçürmə məzmunu: Daxili köçürmə minimum 12 parametrdən ibarət olmalıdır.<br/>";
            //System.out.println("params.length="+params.length);
            return err;
        }

        for (int i = 0; i < params.length; i++) {
            //String paramVal = params[i];

            switch (i) {
                case 0:
                    pMethod = (params[0].trim()).replaceAll("\"", "");
                    isOK = isOnlyUppercaseCharacter(pMethod);

                    if (!isOK) {
                        err += "Sətr:" + lineNum + " :: Yanlış köçürmə tipi:  Xahiş olunur seçim edəsiniz: DM, IT, IN.<br/>";
                    }
                    break;
                case 1:

                    pDate = params[1];
                    isOK = isOnlyNumber(pDate);

                    if (!isOK || pDate.length() != 8 || !isValidDateFormat(pDate)) {
                        err += "Sətr:" + lineNum + " :: Yanlış köçürmə tarixi: Köçürmə tarixi qeyd edilən formatda olmalıdır 'GGAAİİİİ' və cari günə bərabər olmalıdır.<br/>";
                    }
                    break;

                case 2:
                    pAccount = params[2];
                    isOK = isUppecaseNumberAndCharacter(pAccount);

                    if (!isOK || pAccount.length() != 28) {
                        err += "Sətr:" + lineNum + " :: Yanlış hesab nömrəsi: Hesab nömrəsi 28 simvoldan ibarət olmalıdır, özündə rəqəmlər və hərflər əks etdirməlidir.<br/>";
                    }
                    break;

                case 3:
                    pCCY = params[3];
                    accCCY = "";
                    if (pAccount.length() == 28) {
                        accCCY = pAccount.substring(13, 16);
                    }

                    isOK = isOnlyUppercaseCharacter(pCCY);

                    if (!(currencyList.contains(pCCY)) || (!isOK) || !pCCY.equals(accCCY) || isBlank(pCCY)) {
                        err += "Sətr:" + lineNum + " :: Yanlış köçürmə valyutası: Köçürmə valyutası 3 simvoldan ibarət olmalıdır və ancaq böyük hərflər ilə yazılmalıdır. "
                                + "Köçürmə edilən hesab nömrəsinin valyutası ödəniş valyutasi ilə eyni olmalıdır.<br/>";
                    }
                    break;

                case 4:
                    pBenAcc = params[4];
                    isOK = isUppecaseNumberAndCharacter(pBenAcc);

                    if (!isOK || pBenAcc.length() != 28) {
                        err += "Sətr:" + lineNum + " :: Yanlış Benefisiar hesabı: Yanlış Benefisiar hesabı: "
                                + "Benefisiar hesabı 28 simvoldan ibarət olmalıdır özündə rəqəmlər və hərflər əks etdirməlidir.<br/>";
                    }
                    break;
                case 5:
                    pAmount = params[5];
                    isOK = isAmount(pAmount);
                    if (!isOK) {
                        err += "Sətr:" + lineNum + " :: Yanlış məbləğ: Məbləğ rəqəmlərdən ibarət olmalıdır."
                                + " Qəpik məbləği əsas məbləğdən nöqtə ayırıcısı ilə ayrılmalıdır və yüzlüklərə qədər yuvarlaqlaşdırılmalıdır (123.45).<br/>";
                    }
                    break;

                case 6:
                    pDesc = (params[6]).replaceAll("\"", "");
                    isOK = specialCheck(pDesc);

                    //System.out.println("descINT"+pDesc+pDesc.length()+"ddddd"+isOK);
                    if (pDesc.length() > 35 || !isOK) {
                        err += "Sətr:" + lineNum + " :: Yanlış köçürmə təyinatı: Ödənişin təyinatı maksimum 35 simvoldan ibarət olmalıdır və yalnız latın qrafikalı hərflərdən ibarət olmalıdır.<br/>";
                    }
                    break;
            }
        }
        return err;
    }

    public String validateDomesticPayment(String[] params, int lineNum) {
        String err = "";
        String pMethod;
        String pType = "";
        String pAccount = "";
        String accCCY;
        String pDate;
        String pCCY;
        String pBenAcc;
        String pBenName;
        String pVoen;
        String pBenBank;
        String pAmount;
        String pCommAcc;
        String pDesc;
        String pDesc2;
        String pDesc3;
        String pDesc4;

        int paramCount;

        boolean isOK;

        
        paramCount = getLength(params);
        
        
        if(!params[1].toLowerCase().equals("t") && paramCount < 12){
            err += "Sətr:" + lineNum + " :: Yanlış ödəniş məzmunu: Ölkədaxili köçürmə minimum 12 parametrdən ibarət olmalıdır.<br/>";
            return err;
        }
        
        if(!params[1].toLowerCase().equals("t") && paramCount > 15){
            err += "Sətr:" + lineNum + " :: Yanlış ödəniş məzmunu: Ölkədaxili köçürmə maksimum 15 parametrdən ibarət olmalıdır.<br/>";
            return err;
        }
        
        if(params[1].toLowerCase().equals("t") && paramCount < 14){
            err += "Sətr:" + lineNum + " :: Yanlış ödəniş məzmunu: Ölkədaxili(Vergi/Büdcə(T)) köçürmə minimum 14 parametrdən ibarət olmalıdır.<br/>";
            return err;
        }
        
        if(params[1].toLowerCase().equals("t") && paramCount > 15){
            err += "Sətr:" + lineNum + " :: Yanlış ödəniş məzmunu: Ölkədaxili(Vergi/Büdcə(T)) köçürmə maksimum 15 parametrdən ibarət olmalıdır.<br/>";
            return err;
        }
        
        /*paramCount = params.length;
        if (paramCount != 15) {
            err += "Sətr:" + lineNum + " :: Yanlış ödəniş məzmunu: Ölkədaxili köçürmə 15 parametrdən ibarət olmalıdır.<br/>";
            return err;
        }*/

        for (int i = 0; i < params.length; i++) {
            switch (i) {
                case 0:
                    pMethod = (params[0].trim()).replaceAll("\"", "");
                    isOK = isOnlyUppercaseCharacter(pMethod);

                    if (!isOK) {
                        err += "Sətr:" + lineNum + " :: Yanlış ödəniş tipi: Xahiş olunur seçim edəsiniz: DM, IT, IN.<br/>";
                    }
                    break;

                case 1:
                    pType = params[1];
                    //System.out.println("Nt"+pType+" PL"+pTypeList);
                    if (isBlank(pType) || !(pTypeList.contains(pType))) {
                        err += "Sətr:" + lineNum + " :: Yanlış ödəniş növü: Xahiş olunur qeyd edilən (S, U, T) ödəniş növündən birini seçəsiniz.<br/>";
                    }
                    break;

                case 2:
                    pDate = params[2];
                    isOK = isOnlyNumber(pDate);
                    if (!isOK || pDate.length() != 8 || !isValidDateFormat(pDate)) {
                        err += "Sətr:" + lineNum + " :: Yanlış ödəniş tarixi: Köçürmə tarixi qeyd edilən formatda olmalıdır 'GGAAİİİİ' və cari günə bərabər olmalıdır.<br/>";
                    }
                    break;

                case 3:
                    pAccount = params[3];
                    isOK = isUppecaseNumberAndCharacter(pAccount);
                    if (!isOK || pAccount.length() != 28) {
                        err += "Sətr:" + lineNum + " :: Yanlış hesab nömrəsi: Hesab nömrəsi 28 simvoldan ibarət olmalıdır , özündə rəqəmlər və hərflər əks etdirməlidir.<br/>";
                    }
                    break;

                case 4:
                    String accountCurrency = "";
                    pCCY = params[4];

                    if (pAccount.length() == 28) {
                        accountCurrency = pAccount.substring(13, 16);
                    }
                    isOK = isOnlyUppercaseCharacter(pCCY);
                    if (!(currencyList.contains(pCCY)) || (!isOK) || !pCCY.equals(accountCurrency) || isBlank(pCCY)) {
                        err += "Sətr:" + lineNum + " :: Yanlış köçürmə valyutası: Köçürmə valyutası 3 simvoldan ibarət olmalıdır və ancaq böyük hərflər ilə yazılmalıdır. "
                                + "Köçürmə edilən hesab nömrəsinin valyutası ödəniş valyutasi ilə eyni olmalıdır.<br/>";
                    }
                    break;

                case 5:
                    pBenName = params[5];
                    isOK = specialCheck(pBenName);
                    if (!isOK || pBenName.length() > 35 || isBlank(pBenName)) {
                        err += "Sətr:" + lineNum
                                + " :: Yanlış Benefisiar Adı: Benefisiar adı 35 simvoldan və yalnız latın qrafikalı hərflərdən ibarət olmalıdır.<br/>";
                    }
                    break;

                case 6:
                    pBenAcc = params[6];
                    isOK = isUppecaseNumberAndCharacter(pBenAcc);
                    //System.out.println("beeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeen"+pBenAcc);
                    if (!isOK || pBenAcc.length() != 28) {
                        err += "Sətr:"
                                + lineNum + " :: Yanlış Benefisiar Hesabı:"
                                + " Benefisiar hesabı yalnız hərf və rəqəmlərdən təşkil olunmalı və 28 simvoldan ibarət olmalıdır.<br/>";
                    }
                    break;

                case 7:
                    pVoen = params[7];
                    //isOK = isValidVoen(pVoen);
                    /*if (pVoen.length() != 10 || !isValidVoen(pVoen)) {
                     err += "Sətr:" + lineNum + " :: Yanlış VÖEN: VÖEN rəqəmlər ilə yazılmalıdır (10 simvol) və axırda 1 və 2 rəqəmi ilə bitməlidir.<br/>";
                     }*/
                    if (pType.equals("T")) {
                        if (pVoen.length() != 10 || !isValidVoen(pVoen)) {
                            err += "Sətr:" + lineNum + " :: Yanlış VÖEN: VÖEN rəqəmlər ilə yazılmalıdır (10 simvol) və axırda 1 və 2 rəqəmi ilə bitməlidir.<br/>";
                        }
                    } else {
                        if (!isBlank(pVoen) && !isValidVoen(pVoen) && pVoen.length() != 10) {
                            err += "Sətr:" + lineNum + " :: Yanlış VÖEN: VÖEN rəqəmlər ilə yazılmalıdır (10 simvol) və axırda 1 və 2 rəqəmi ilə bitməlidir.<br/>";
                        }
                    }
                    break;

                case 8:
                    pBenBank = params[8];
                    isOK = isOnlyNumber(pBenBank);
                    if (pBenBank.length() != 6 || !isOK) {
                        err += "Sətr:" + lineNum + " :: Yanlış Benefisar Bank kodu: Bank kodu rəqəm ilə yazılmalıdır və 6 simvola  bərbər olmalıdır.<br/>";
                    }
                    break;

                case 9:
                    pAmount = params[9];
                    isOK = isAmount(pAmount);
                    if (!isOK || isBlank(pAmount)) {
                        err += "Sətr:" + lineNum
                                + " :: Məbləğ yanlışdır: Məbləğ rəqəmlərdən ibarət olmalıdır. "
                                + "Qəpik məbləği əsas məbləğdən nöqtə ayırıcısı ilə ayrılmalıdır və yüzlüklərə qədər yuvarlaqlaşdırılmalıdır (123.45).<br/>";
                    }
                    /*else if (pType.equals("S") && Double.parseDouble(pAmount) > 40000) {
                     err += "Sətr:" + lineNum + " :: Məbləğ yanlışdır: Amount must be no more than 40000 AZN for Standart payments.<br/>";
                     }*/

                    break;
                case 10:
                    pCommAcc = params[10];
                    isOK = isUppecaseNumberAndCharacter(pCommAcc);
                    if (!isOK || pCommAcc.length() != 28) {
                        err += "Sətr:" + lineNum
                                + " :: Yanlış komisyon hesabı: Komisyon hesabı 28 simvoldan, rəqəm və həriflərdən ibarət olmalıdır.<br/>";
                    }
                    break;
                case 11:
                    pDesc = params[11];
                    if (pType.equals("T")) {
                        if (!paymentBudgetLevelList.contains(pDesc) || isBlank(pDesc)) {
                            err += "Sətr:" + lineNum + " :: Ödəniş təyinatı 1(büdcə səviyyəsinin kodu) yanlışdır : Büdcə səviyyəsi kodu bunlardan biri olmalıdır: 1, 1Y, 2, 2Y, 3, 3Y, 4, 4Y, 5, 5Y, 6, 6Y, 7, 7Y.<br/>";
                        }

                    } else {
                        if (pDesc.length() > 35 || !specialCheck(pDesc) || isBlank(pDesc)) {
                            err += "Sətr:" + lineNum + " :: Yanlış köçürmə təyinatı 1: Ödənişin təyinatı maksimum 35 simvoldan ibarət olmalıdır və yalnız latın qrafikalı hərflərdən ibarət olmalıdır.<br/>";
                        }
                    }
                    break;
                case 12:
                    pDesc2 = params[12];

                    if (pType.equals("T")) {
                        if (isBlank(pDesc2) || !isOnlyNumber(pDesc2) || pDesc2.trim().length() != 6) {
                            err += "Sətr:" + lineNum + " :: Ödəniş təyinatı 2(büdcə təsnifat kodu) yanlışdır : Büdcə təsnifatı kodu 6 rəqəmdən ibarət olmalıdır. Misal: 123456.<br/>";
                        }
                    } else {
                        if (pDesc2.length() > 35 || !specialCheckCanBeNull(pDesc2)) {
                            err += "Sətr:" + lineNum + " :: Yanlış köçürmə təyinatı 2: Ödənişin təyinatı maksimum 35 simvoldan ibarət olmalıdır və yalnız latın qrafikalı hərflərdən ibarət olmalıdır.<br/>";
                        }
                    }

                    break;
                case 13:
                    pDesc3 = params[13];

                    if (pDesc3.length() > 35 || !specialCheckCanBeNull(pDesc3)) {
                        err += "Sətr:" + lineNum + " :: Yanlış köçürmə təyinatı 3: Ödənişin təyinatı maksimum 35 simvoldan ibarət olmalıdır və yalnız latın qrafikalı hərflərdən ibarət olmalıdır.<br/>";
                    }
                    break;
                case 14:
                    pDesc4 = (params[14].trim()).replaceAll("\"", "");
                    if (pDesc4.length() > 35 || !specialCheckCanBeNull(pDesc4)) {
                        err += "Sətr:" + lineNum + " :: Yanlış köçürmə təyinatı 4: Ödənişin təyinatı maksimum 35 simvoldan ibarət olmalıdır və yalnız latın qrafikalı hərflərdən ibarət olmalıdır.<br/>";
                    }
                    break;
            }
        }
        return err;
    }

    public String validateInternationalPayment(String[] params, int lineNum) {
        String err = "";
        String pMethod;
        String pType = "";
        String pAccount = "";
        String accCCY;
        String pDate;
        String pCCY;
        String pBenAcc;
        String pBenName;
        String pVoen;
        String pBenBank;
        String pBenSwift;
        String pMuxbirSwift;
        String pBenInfo;
        String pAmount;
        String pCommAcc;
        String pDesc;
        String pDesc2;
        String pDesc3;
        String pDesc4;

        int paramCount;

        boolean isOK;

        
        paramCount = getLength(params);
        if (paramCount < 11 || paramCount > 15) {
            err += "Sətr:" + lineNum + " :: Ödənişin məzmunu yanlışdır. Beynəlxalq ödəniş 11 parametrdən ibarət olmalıdır.<br/>";
            return err;
        }
        
        /*paramCount = params.length;
        if (paramCount != 15) {
            err += "Sətr:" + lineNum + " :: Ödənişin məzmunu yanlışdır. Beynəlxalq ödəniş 15 parametrdən ibarət olmalıdır.<br/>";
            return err;
        }*/

        for (int i = 0; i < params.length; i++) {
            switch (i) {
                case 0:
                    pMethod = (params[0].trim()).replaceAll("\"", "");
                    isOK = isOnlyUppercaseCharacter(pMethod);

                    if (!isOK) {
                        err += "Sətr:" + lineNum + " :: Yanlış ödənişin üsulu. Bunlardan birini seçin DM, IT, IN.<br/>";
                    }
                    break;
                case 1:
                    pDate = params[1];
                    isOK = isOnlyNumber(pDate);
                    if (!isOK || pDate.length() != 8 || !isValidDateFormat(pDate)) {
                        err += "Sətr:" + lineNum + " :: Yanlış köçürmə tarixi: Köçürmə tarixi qeyd edilən formatda olmalıdır 'GGAAİİİİ' və cari günə bərabər olmalıdır.<br/>";
                    }
                    break;
                case 2:
                    pAccount = params[2];
                    isOK = isUppecaseNumberAndCharacter(pAccount);
                    if (!isOK || pAccount.length() != 28) {
                        err += "Sətr:" + lineNum + " :: Hesab nömrəsi 28 simvoldan, hərf və rəqəmlərdən ibarət olunmalıdır.<br/>";
                    }
                    break;
                case 3:
                    String accountCurrency = "";
                    pCCY = params[3];
                    if (pAccount.length() == 28) {
                        accountCurrency = pAccount.substring(13, 16);
                    }
                    isOK = isOnlyUppercaseCharacter(pCCY);
                    //System.out.println(pCCY+"ddd"+isOK);
                    if (!(currencyList.contains(pCCY)) || (!isOK) || !pCCY.equals(accountCurrency) || isBlank(pCCY)) {
                        err += "Sətr:" + lineNum + " :: Yanlış ödənişin valyutası: Vaıyutanın uzunlugu 3 simvoldan ve böyük hərflərdən ibarət olunmalıdır."
                                + " Ödəyənin valyutası ödəniş tapşırığının vaıyutası ilə eyni olmalıdır.<br/>";
                    }
                    break;
                case 4:
                    pBenName = params[4];
                    isOK = specialCheck(pBenName);
                    if (!isOK || pBenName.length() > 35 || isBlank(pBenName)) {
                        err += "Sətr:" + lineNum + " :: Yanlış Benefisiar Adı: Benefisiar adı 35 simvoldan və yalnız latın qrafikalı hərflərdən ibarət olmalıdır.<br/>";
                    }
                    break;
                case 5:
                    pBenAcc = params[5];
                    isOK = isUppecaseNumberAndCharacter(pBenAcc);

                    if (!isOK /*|| pBenAcc.length() != 28*/) {
                        err += "Sətr:" + lineNum + " ::Yanlış Benefisiar Hesabı:"
                                + " Benefisiar hesabı yalnız hərf və rəqəmlərdən təşkil olunmalıdır.<br/>";
                    }
                    break;
                case 6:
                    pBenInfo = params[6];
                    isOK = specialCheck(pBenInfo);
                    if (pBenInfo.length() > 35 || !isOK || isBlank(pBenInfo)) {
                        err += "Sətr:" + lineNum + " :: Yanlış Benefisiarın Ünvanı: Benefisiar ünvanı maksimum 35 simvoldan və yalnız latın qrafikalı hərflərdən ibarət olmalıdır.<br/>";

                    }
                    break;
                case 7:
                    pBenSwift = params[7];
                    isOK = isUppecaseNumberAndCharacter(pBenSwift);
                    if (!isOK || isBlank(pBenSwift)) {
                        err += "Sətr:" + lineNum + " :: Yanlış Benefisiarın Swift kodu: Benefisiarın Swift kodu vacibdır rəqəm və həriflərdən ibarət oluna bilər.<br/>";

                    }
                    break;
                case 8:
                    pMuxbirSwift = params[8];
                    isOK = isUppecaseNumberAndCharacterCanBeNull(pMuxbirSwift);
                    if (!isOK) {
                        err += "Sətr:" + lineNum + " :: Yanlış Müxbir Swift Kod : Müxbir Swift Kod rəqəm və həriflərdən ibarət ola bilər.<br/>";
                    }
                    break;
                case 9:
                    pAmount = params[9];
                    isOK = isAmount(pAmount);
                    if (!isOK) {
                        err += "Sətr:" + lineNum + " :: Yanlış Məbləğ: Məbləğ rəqəmlərdən ibarət olmalıdır. Qəpik məbləği əsas məbləğdən nöqtə ayırıcısı ilə ayrılmalıdır və yüzlüklərə qədər yuvarlaqlaşdırılmalıdır (123.45).<br/>";
                    }
                    break;
                case 10:
                    pCommAcc = params[10];
                    isOK = isUppecaseNumberAndCharacter(pCommAcc);
                    if (!isOK || pCommAcc.length() != 28) {
                        err += "Sətr:" + lineNum + " :: Yanlış Komissiya Hesabı: Komissiya hesabı yalnız hərf və rəqəmlərdən təşkil olunmalı və 28 simvoldan ibarət olmalıdır.<br/>";
                    }
                    break;
                case 11:
                    pDesc = params[11];
                    if (pDesc.length() > 35 || !specialCheck(pDesc) || isBlank(pDesc)) {
                        err += "Sətr:" + lineNum + " :: Yanlış Ödənişin təyinatı 1: Ödənişin təyinatı maksimum 35 simvoldan ibarət olmalıdır və yalnız latın qrafikalı hərflərdən ibarət olmalıdır.<br/>";

                    }
                    break;
                case 12:
                    pDesc2 = params[12];
                    if (pDesc2.length() > 35 || !specialCheckCanBeNull(pDesc2)) {
                        err += "Sətr:" + lineNum + " :: Yanlış Ödənişin təyinatı 2: Ödənişin təyinatı maksimum 35 simvoldan ibarət olmalıdır və yalnız latın qrafikalı hərflərdən ibarət olmalıdır.<br/>";

                    }
                    break;
                case 13:
                    pDesc3 = params[13];
                    if (pDesc3.length() > 35 || !specialCheckCanBeNull(pDesc3)) {
                        err += "Sətr:" + lineNum + " :: Yanlış Ödənişin təyinatı 3: Ödənişin təyinatı maksimum 35 simvoldan ibarət olmalıdır və yalnız latın qrafikalı hərflərdən ibarət olmalıdır.<br/>";

                    }
                    break;
                case 14:
                    pDesc4 = (params[14].trim()).replaceAll("\"", "");
                    if (pDesc4.length() > 35 || !specialCheckCanBeNull(pDesc4)) {
                        err += "Sətr:" + lineNum + " :: Yanlış Ödənişin təyinatı 4: Ödənişin təyinatı maksimum 35 simvoldan ibarət olmalıdır və yalnız latın qrafikalı hərflərdən ibarət olmalıdır.<br/>";

                    }
                    break;
            }
        }
        return err;
    }

    public String validateSalaryPayment(String[] params, int lineNum) {
        String err = "";
        //String pCCY;
        String pBenAcc;
        String pBenName;
        String pAmount;
        String pDesc;
        String pSalType;

        int paramCount;

        boolean isOK;

        paramCount = params.length;
        if (paramCount != 5) {
            err += "Sətr:" + lineNum + " :: Faylda xəta mövcuddur: Əmək-haqqı ödənişi 5 parametrdən ibarət olmalıdır.<br/>";
            return err;
        }

        for (int i = 0; i < params.length; i++) {
            switch (i) {
                case 0:
                    pBenName = params[0];
                    isOK = specialCheck(pBenName);
                    if (!isOK || pBenName.length() > 35 || isBlank(pBenName)) {
                        err += "Sətr:" + lineNum + " :: Yanlış Benefisiar Adı: Benefisiar adı 35 simvoldan və yalnız latın qrafikalı hərflərdən ibarət olmalıdır.<br/>";
                    }
                    break;
                case 1:
                    pBenAcc = params[1];
                    isOK = isUppecaseNumberAndCharacter(pBenAcc);

                    if (!isOK || pBenAcc.length() != 28) {
                        err += "Sətr:" + lineNum + " :: Yanlış Benefisiar Hesabı:"
                                + " Benefisiar hesabı yalnız hərf və rəqəmlərdən təşkil olunmalı və 28 simvoldan ibarət olmalıdır.<br/>";
                    }
                    break;
                case 2:
                    pAmount = params[2];
                    isOK = isAmount(pAmount);
                    if (!isOK) {
                        err += "Sətr:" + lineNum + " :: Yanlış məbləğ: Məbləğ rəqəmlərdən ibarət olmalıdır. "
                                + "Qəpik məbləği əsas məbləğdən nöqtə ayırıcısı ilə ayrılmalıdır və yüzlüklərə qədər yuvarlaqlaşdırılmalıdır (123.45).<br/>";
                    }
                    break;
                case 3:
                    pDesc = params[3];
                    if (pDesc.length() > 35 || !specialCheck(pDesc) || isBlank(pDesc)) {
                        err += "Sətr:" + lineNum + " :: Yanlış Ödənişin təyinatı: Ödənişin təyinatı maksimum 35 simvoldan ibarət olmalıdır və yalnız latın qrafikalı hərflərdən ibarət olmalıdır.<br/>";

                    }
                    break;
                case 4:
                    pSalType = params[4];
                    isOK = specialCheck(pSalType);
                    if (!isOK || isBlank(pSalType) || !(pSalTypeList.contains(pSalType))) {
                        err += "Sətr:" + lineNum + " :: Yanlış əmək-haqqı tipi: Əmək-haqqı tipi olaraq bunlardan biri seçilməlidir: EH,SHH,AMH,AV,BN,MKF,TQD,MY,DG,YSH,XH,BP,EZM,KMP.<br/>";
                    }
                    break;
            }
        }
        return err;
    }

    //SIMPLE CHECKS
    public boolean isBlank(String value) {
        return (value == null || value.equals("") || value.equals("null") || value.trim().equals(""));

    }

    public boolean isOnlyNumber(String value) {
        boolean ret = false;
        if (!isBlank(value)) {
            ret = value.matches("^[0-9]*$");
        }
        return ret;
    }

    public boolean isOnlyCharacter(String value) {
        boolean ret = false;
        if (!isBlank(value)) {
            ret = value.matches("^[a-zA-Z]*$");
        }
        return ret;
    }

    public boolean isOnlyUppercaseCharacter(String value) {
        boolean ret = false;
        if (!isBlank(value)) {
            ret = value.matches("^[A-Z]*$");
        }
        return ret;
    }

    public boolean isNumberAndCharacter(String value) {
        boolean ret = false;
        if (!isBlank(value)) {
            ret = value.matches("^[0-9a-zA-Z]*$");
        }
        return ret;
    }

    public boolean isUppecaseNumberAndCharacter(String value) {
        boolean ret = false;
        if (!isBlank(value)) {
            ret = value.matches("^[0-9A-Z]*$");
        }
        return ret;
    }

    public boolean isUppecaseNumberAndCharacterCanBeNull(String value) {
        boolean ret = false;
        if (!isBlank(value)) {
            ret = value.matches("^[0-9A-Z]*$");
        } else {
            ret = true;
        }
        return ret;
    }

    public boolean isAmount(String input) {
        boolean ret = false;
        if (!isBlank(input)) {
            ret = input.matches("^\\d+(\\.\\d{1,2})?$");
        }
        return ret;
    }

    public boolean specialCheck(String input) {
        boolean ret = false;
        if (!isBlank(input)) {
            ret = input.matches("^[a-zA-Z0-9 ./\\[\\]-]*$");
        }
        return ret;
    }

    public boolean specialCheckCanBeNull(String input) {
        boolean ret = false;
        if (!isBlank(input)) {
            ret = input.matches("^[a-zA-Z0-9 ./\\[\\]-]*$");
        } else {

            ret = true;
        }
        return ret;
    }

    public boolean isValidDateFormat(String pDate) {
        boolean ret = false;
        String bkpPaymentDate = pDate;
        String regex = "^(?:(?:(?:0?[13578]|1[02])(\\/|-|\\.)31)\\1|(?:(?:0?[1,3-9]|1[0-2])(\\/|-|\\.)(?:29|30)\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:0?2(\\/|-|\\.)29\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:(?:0?[1-9])|(?:1[0-2]))(\\/|-|\\.)(?:0?[1-9]|1\\d|2[0-8])\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        String day, month, year = "";
        day = pDate.substring(0, 2) + "/";
        month = pDate.substring(2, 4) + "/";
        year = pDate.substring(4, 8);
        pDate = month + day + year;

        if (!isBlank(pDate)) {
            ret = pDate.matches(regex);
        }
        if (ret) {
            Calendar c = Calendar.getInstance();
            Date today = c.getTime();
            int numYear = Integer.parseInt(bkpPaymentDate.substring(4, 8));
            int numMonth = Integer.parseInt(bkpPaymentDate.substring(2, 4)) % 12;
            int numDay = Integer.parseInt(bkpPaymentDate.substring(0, 2));

            c.set(Calendar.YEAR, numYear);
            c.set(Calendar.MONTH, numMonth - 1);
            c.set(Calendar.DAY_OF_MONTH, numDay);

            Date dateSpecified = c.getTime();
            /* System.out.println("bkpPaymentDate>>" + bkpPaymentDate + "dateSpecified>>" + dateSpecified + "today>>>>" + today + "dateSpecified.before(today)>>"
             + dateSpecified.before(today) + "dateSpecified.equal(today)" + dateSpecified.equals(today)
             + "dateSpecified.after(today)" + dateSpecified.after(today));*/
            if (dateSpecified.before(today)) {
                ret = false;
            } else if (dateSpecified.equals(today)) {
                ret = true;
            } else if (dateSpecified.after(today)) {
                ret = false;
            }
        }
        return ret;
    }

    public boolean isValidVoen(String paymentVoen) {

        boolean ret = false;
        ret = isOnlyNumber(paymentVoen);
        if (ret) {
            if (paymentVoen.substring(9, 10).equals("1") || paymentVoen.substring(9, 10).equals("2")) {
                ret = true;
            } else {
                ret = false;
            }
        } else {
            ret = false;
        }
//        System.out.println("paymentVoen.substring(9, 10)" + paymentVoen.substring(9, 10) + ret);
        return ret;

    }

    /**
     * Getting correct length from excell line length
     * @param params
     * @return size
     */
    private int getLength(String[] params) {
        int count = 0;
        for (int i = 0; i < params.length; i++) {
            if (!params[i].equals("")) {
                count++;
            } else {
                System.out.println("here");
            }
        }

        return count;
    }
}

