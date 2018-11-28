package com.sprintzeal.sprint.sprintzeal;

public class Questions {
    public String mQuestions[] = {" Press Freedom Day is celebrated on",
            "World Red Cross Day falls on",
            " Which one of the following days is observed as the World Environment Day",
            " Human Rights Day is observed on",
            " Friendship day is celebrated on"};
    public String mchoice[][] = {{". May 1",". May 2",". May 3",". May 4"},
            {". May 3",". May 8",". May 10",". May 11"},
            {"World Religious Day","National Youth Day"," All saints Day","Hindu Renaissance Day"},
            {"December 10","December 14","December 25","December 28"},{"August 1","August 3","August 5","August 8"}};
    public String manswer[]={". May 3",". May 8","National Youth Day","December 10","August 3"};

    public String getquestions(int a){
        String question=mQuestions[a];
        return question;
    }
    public String getchoice1(int a){
        String choice=mchoice[a][0];
        return choice;
    }
    public String getchoice2(int a){
        String choice=mchoice[a][1];
        return choice;
    }
    public String getchoice3(int a){
        String choice=mchoice[a][2];
        return choice;
    }
    public String getchoice4(int a){
        String choice=mchoice[a][3];
        return choice;
    }

    public String getanswer(int a){
        String answer=manswer[a];
        return answer;
    }
}
