package com.patika.kredinbizdenservice.model;


import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.enums.SectorType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

public class SingleHandler {

    private List<CreditCard> creditCards;
    private List<User> userList;
    private List<Bank> bankList;
    private static final SingleHandler instance = new SingleHandler();

    private SingleHandler(){
        this.userList= new ArrayList<User>();
        this.bankList=new ArrayList<Bank>();

        User user1= new User("Cem","Dırman", LocalDate.parse("1990-10-10"),"cemdrman@gmail.com","xXxxX","5554443322",true);
        User user2= new User("Enes","Yurtcu", LocalDate.parse("1999-01-29"),"enes_yurtcu@hotmail.com","password","5554443322",true);
        User user3=new User("Ali","Kaya", LocalDate.parse("1989-08-19"),"alikaya@hotmail.com","asdasdasd","5554443322",true);
        addNewUser(user1);
        addNewUser(user2);
        addNewUser(user3);


        Bank garantiBank=new Bank("Garanti");
        Bank yapıKrediBank=new Bank("YapıKredi");
        Bank ziraatBank=new Bank("Ziraat");
        bankList.add(garantiBank);
        bankList.add(ziraatBank);
        bankList.add(yapıKrediBank);


        //Creating dummy data for Loan

        Application application=new Application(LoanFactory.getLoan(LoanType.ARAC_KREDISI,garantiBank, BigDecimal.valueOf(45645),5,10.0),user1, LocalDateTime.of(2024, 3, 10, 18, 19));
        user1.addNewApplication(application);
        garantiBank.addNewApplication(application);

        application=new Application(LoanFactory.getLoan(LoanType.IHTIYAC_KREDISI,garantiBank, BigDecimal.valueOf(12122),3,12.7),user1, LocalDateTime.of(2022, 12, 15, 3, 25));
        user1.addNewApplication(application);
        garantiBank.addNewApplication(application);

        application=new Application(LoanFactory.getLoan(LoanType.ARAC_KREDISI,yapıKrediBank, BigDecimal.valueOf(64565),6,9.8),user2, LocalDateTime.of(2023, 8, 15, 4, 21));
        user2.addNewApplication(application);
        yapıKrediBank.addNewApplication(application);

        application=new Application(LoanFactory.getLoan(LoanType.KONUT_KREDISI,yapıKrediBank, BigDecimal.valueOf(59789),5,10.5),user2, LocalDateTime.of(2021, 9, 15, 5, 15));
        user2.addNewApplication(application);
        yapıKrediBank.addNewApplication(application);


        application=new Application(LoanFactory.getLoan(LoanType.IHTIYAC_KREDISI,ziraatBank, BigDecimal.valueOf(35745),4,10.2),user3, LocalDateTime.of(2024, 1, 17, 5, 45));
        user3.addNewApplication(application);
        ziraatBank.addNewApplication(application);

        application=new Application(LoanFactory.getLoan(LoanType.KONUT_KREDISI,garantiBank, BigDecimal.valueOf(89789),8,7.2),user2, LocalDateTime.of(2024, 3, 2, 8, 19));
        user2.addNewApplication(application);
        garantiBank.addNewApplication(application);

        application=new Application(LoanFactory.getLoan(LoanType.ARAC_KREDISI,ziraatBank, BigDecimal.valueOf(89453),9,6.4),user3, LocalDateTime.of(2024, 3, 15, 11, 49));
        user3.addNewApplication(application);
        ziraatBank.addNewApplication(application);


        application=new Application(LoanFactory.getLoan(LoanType.ARAC_KREDISI,yapıKrediBank, BigDecimal.valueOf(78565),7,8.9),user1, LocalDateTime.of(2023, 10, 15, 13, 54));
        user1.addNewApplication(application);
        yapıKrediBank.addNewApplication(application);

        application=new Application(LoanFactory.getLoan(LoanType.KONUT_KREDISI,ziraatBank, BigDecimal.valueOf(55675),7,9.3),user2, LocalDateTime.of(2022, 6, 15, 23, 57));
        user2.addNewApplication(application);
        ziraatBank.addNewApplication(application);

        application=new Application(LoanFactory.getLoan(LoanType.IHTIYAC_KREDISI,yapıKrediBank, BigDecimal.valueOf(35678),5,7.8),user2, LocalDateTime.of(2021, 8, 15, 0, 49));
        user2.addNewApplication(application);
        yapıKrediBank.addNewApplication(application);

        application=new Application(LoanFactory.getLoan(LoanType.KONUT_KREDISI,garantiBank, BigDecimal.valueOf(45678),4,11.5),user3, LocalDateTime.of(2020, 5, 15, 20, 01));
        user3.addNewApplication(application);
        garantiBank.addNewApplication(application);

        application=new Application(LoanFactory.getLoan(LoanType.IHTIYAC_KREDISI,ziraatBank, BigDecimal.valueOf(26374),5,10.7),user1, LocalDateTime.of(2024, 3, 12, 21, 14));
        user1.addNewApplication(application);
        ziraatBank.addNewApplication(application);

        application=new Application(LoanFactory.getLoan(LoanType.ARAC_KREDISI,garantiBank, BigDecimal.valueOf(7867),3,9.9),user3, LocalDateTime.of(2024, 2, 17, 17, 12));
        user3.addNewApplication(application);
        garantiBank.addNewApplication(application);

        application=new Application(LoanFactory.getLoan(LoanType.IHTIYAC_KREDISI,ziraatBank, BigDecimal.valueOf(78925),12,12.4),user1, LocalDateTime.of(2023, 4, 15, 18, 27));
        user1.addNewApplication(application);
        ziraatBank.addNewApplication(application);

        application=new Application(LoanFactory.getLoan(LoanType.KONUT_KREDISI,yapıKrediBank, BigDecimal.valueOf(24626),10,8.8),user1, LocalDateTime.of(2022, 11, 15, 16, 31));
        user1.addNewApplication(application);
        yapıKrediBank.addNewApplication(application);

        //Dummy data for Credit card and campaigns
        //Note: Credit Card list in Bank, means the credit cards and owners of them.
        //So, banks has no applications for credit cards yet. These credit cards and campaigns are cretead but not added to banks. Because they must be associated with a user.
        creditCards=new ArrayList<CreditCard>();
        List<Campaign> campaignList=new ArrayList<Campaign>();
        Campaign campaign;

        campaign=new Campaign("Ayda 7.000 TL'ye Varan Bonus!",
                "Hemen Bonus'a Başvur, Ayda 7.000 TL'ye Varan Bonus Kazan!!",
                LocalDate.of(2024, 3, 31),
                LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 1, 1),
                SectorType.OTHERS
                );
        campaignList.add(campaign);
        campaign=new Campaign("2024 Ramazan Bayramı Kampanyası!",
                "Bonus üye işyeri marketlerde yapacağınız 750 TL ve üzeri her ikinci işleme 100 TL bonus, toplam 800 TL bonus; GarantiPay ile ekstra 200 TL bonus!",
                LocalDate.of(2024, 4, 15),
                LocalDate.of(2024, 3, 10),
                LocalDate.of(2024, 3, 10),
                SectorType.MARKET
        );
        campaignList.add(campaign);
        campaign=new Campaign("Okul Ödemenize 400 TL Bonus!",
                "31 Mart 2024 tarihlerine kadar giyim, aksesuar, ayakkabı, optik ve saat sektörlerinde, kampanyaya dahil üye işyerlerinden yapılan, taksitli 750 TL ve üzeri alışverişlerde +3 taksit!",
                LocalDate.of(2024, 3, 31),
                LocalDate.of(2024, 2, 20),
                LocalDate.of(2024, 3, 1),
                SectorType.OTHERS
        );
        campaignList.add(campaign);
                campaign=new Campaign("Beyaz Eşya Alışverişinize 200 TL Bonus!",
                "31 Mart'a kadar BonusFlaş üzerinden ya da SMS ile kampanyaya katılın, Garanti BBVA POS'larından tek seferde yapacağınız 7.500 TL ve üzeri beyaz eşya alışverişinize 200 TL bonus!",
                LocalDate.of(2024, 3, 31),
                LocalDate.of(2024, 3, 1),
                LocalDate.of(2024, 3, 1),
                SectorType.MARKET
        );
        campaignList.add(campaign);
        CreditCard creditCard=new CreditCard(garantiBank,BigDecimal.valueOf(583),new ArrayList<Campaign>(campaignList));
        creditCards.add(creditCard);
        campaignList.clear();


        campaign=new Campaign("Gıda Marketi Alışverişlerinize Toplamda 800 TL Worldpuan!",
                "3000 TL ve üzeri gıda marketi alışverişlerinize toplamda 600 TL’ye varan, World Pay ile ek 200 TL’ye varan, toplamda 800 TL’ye varan Worldpuan!",
                LocalDate.of(2024, 4, 14),
                LocalDate.of(2024, 3, 7),
                LocalDate.of(2024, 3, 7),
                SectorType.OTHERS
        );
        campaignList.add(campaign);
        campaign=new Campaign("English Home’da Peşin Fiyatına 6 Taksit!",
                "Kampanya 1 Eylül 2023 – 30 Mart 2024 tarihleri arasında geçerlidir!",
                LocalDate.of(2024, 4, 15),
                LocalDate.of(2024, 3, 10),
                LocalDate.of(2024, 3, 10),
                SectorType.OTHERS
        );
        campaignList.add(campaign);
        creditCard=new CreditCard(yapıKrediBank,BigDecimal.valueOf(583),new ArrayList<Campaign>(campaignList));
        creditCards.add(creditCard);
        campaignList.clear();


        campaign=new Campaign("Alışverişlerinizi Sonradan Bankkart Lira ile Ödeyin!",
        "Bankkart Lira ile Öde özelliği Bankkart Liranızı alışverişten sonra da harcayabilme fırsatı sunuyor!",                LocalDate.of(2024, 4, 14),
                LocalDate.of(2024, 3, 7),
                LocalDate.of(2024, 3, 7),
                SectorType.OTHERS
        );
        campaignList.add(campaign);
        creditCard=new CreditCard(ziraatBank,BigDecimal.valueOf(583),new ArrayList<Campaign>(campaignList));
        creditCards.add(creditCard);
        campaignList.clear();



    }

    public void printCreditCardsDescending() {
        List<CreditCard> sortedCards = creditCards.stream()
                .sorted((c1, c2) -> c2.getCampaignList().size() - c1.getCampaignList().size())
                .collect(Collectors.toList());
        for (CreditCard card : sortedCards) {
            System.out.println("Kredi Kartının ait olduğu Banka: "+card.getBank().getName()+", Kampanya Sayısı: " + card.getCampaignList().size());
        }

    }


    public void printApplicationsByEmail(String email){
        boolean found=false;
        int i=0;
        while (!found & i<userList.size()){
            if(userList.get(i).getEmail().equals(email)){
                found=true;
                printApplicationsUser(userList.get(i));
            }
            i++;
        }
        if(!found){
            System.out.println("User not found with this email:"+email);
        }

    }

    private void printApplicationsUser(User user) {
        List<Application> applicationList=user.getApplicationList();
        for(Application application: applicationList){
            System.out.println(user.getName()+" "+user.getSurname()+", "+application.getBankProduct().getAmount());
        }
    }


    public void printApplicationsLastMont(){//prints all applications in last 30 days
        List<Application> applicationList=getApplicationsFromLastMonth();
        for(Application application:applicationList){
            System.out.println(application.getLocalDateTime().toString()+", "+application.getUser().getName()+" "+application.getUser().getSurname()+", "+application.getBankProduct().getAmount());
        }
    }
    public List<Application> getApplicationsFromLastMonth() {//returns all applications in last 30 days
        LocalDateTime oneMonthAgo = LocalDateTime.now().minus(1, ChronoUnit.MONTHS);
        List<Application> applicationsLastMonth = new ArrayList<Application>();
        for(User user: userList){
            List<Application> userApplications=user.getApplicationList();

            for (Application app : userApplications) {
                if (app.getLocalDateTime().isAfter(oneMonthAgo)) {
                    applicationsLastMonth.add(app);
                }
            }
        }
        return applicationsLastMonth;
    }
    public void printHighestApplication(){
        BigDecimal highestApplication=BigDecimal.ZERO;
        User highestApplicantUser=new User();
        BigDecimal currentApplication=BigDecimal.ZERO;
        List<Application> applicationList;
        for(User user: userList){
            applicationList=user.getApplicationList();
            for(Application application: applicationList){
                currentApplication=application.getBankProduct().getAmount();
                //System.out.println(user.getName()+" "+user.getSurname()+", "+currentApplication);
                if(currentApplication.compareTo(highestApplication) > 0){//if current application is bigger than highest application
                    highestApplication=currentApplication;
                    highestApplicantUser=user;
                }
            }

        }
        System.out.println("Highest Application is: "+highestApplication+" by "+highestApplicantUser.getName()+" "+highestApplicantUser.getSurname());


    }

    public void printMostApplicantUser() {
        User mostApplicantUser=new User();
        int mostApplicantCount=0;
        int size=0;
        for(User user: userList){
            size=user.getApplicationList().size();
            //System.out.println("User: "+user.getName()+" "+user.getSurname()+", with "+size+" application");
            if(size>mostApplicantCount){
                mostApplicantUser=user;
                mostApplicantCount=size;
            }
        }
        System.out.println("Most Applicant User: "+mostApplicantUser.getName()+" "+mostApplicantUser.getSurname()+", with "+mostApplicantCount+" application");
    }


    public void addNewUser(User newUser) {
        for(User user: userList){
            if(user.getEmail().equals(newUser.getEmail())){
                System.out.println("User with this email already exists.");
                return;
            }
        }
        userList.add(newUser);
    }

    //Get the only object available
    public static SingleHandler getInstance(){
        return instance;
    }


}