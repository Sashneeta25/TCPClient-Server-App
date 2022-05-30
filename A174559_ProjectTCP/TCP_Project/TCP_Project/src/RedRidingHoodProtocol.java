public class RedRidingHoodProtocol {
    
    String start = "It's your grandmother Red Riding Hood! I'm waiting for you..."; 						//start
    String [] theWolf = {"Who is there?", 																	//0
                         "Hi dear Red Riding Hood! Pull the latch and come in! What do you have for me?",	//1
                         "Put the cake on the counter and come close to me.",								//2
                         "The better to embrace you, my child.", 											//3
                         "The better to run with, my child.", 												//4
                         "The better to hear with, my child.", 												//5
                         "The better to see with, my child.", 												//6
                         "The better to eat you with!",														//7
                         "MUAHAHAHA YOU HAVE BEEN TRICKED! PLAY AGAIN? [Y/N]"}; 							//8
    
    String [] redRidingHood = {"Tok tok",											//0
                               "It's your grand daughter the Red Riding Hood!",		//1
                               "Hello grandmother! I brought you some cake!",		//2
                               "Grandmother dear, what big arms you have!",			//3
                               "Grandmother dear, what big legs you have!",			//4
                               "Grandmother dear, what big ears you have!",			//5
                               "Grandmother dear, what big eyes you have!",			//6
                               "Grandmother dear, what big teeth you have!",		//7
                               "Ahhhhhhhhhhhh!!!"};									//8
    
    private static final int WAITING = 0;
    private int state = WAITING;
    
    public String processInput(String input){
        String output = null;
       
        if(state == 1){
            if(input.equalsIgnoreCase(redRidingHood[0])){
                output = theWolf[0];
                state = 2;
            }
            else
                output = "You are supposed to say \"" + redRidingHood[0] + "\" Try again Red Riding Hood!";
        }
        else if(state == 2){
             if(input.equalsIgnoreCase(redRidingHood[1])){
                output = theWolf[1];
                state = 3;
            }
            else
                output = "You are supposed to say \"" + redRidingHood[1] + "\" Try again Red Riding Hood!";
        }
        else if(state == 3){
             if(input.equalsIgnoreCase(redRidingHood[2])){
                output = theWolf[2];
                state = 4;
            }
            else
                output = "You are supposed to say \"" + redRidingHood[2] + "\" Try again Red Riding Hood!";
        }
        else if(state == 4){
             if(input.equalsIgnoreCase(redRidingHood[3])){
                output = theWolf[3];
                state = 5;
            }
            else
                output = "You are supposed to say \"" + redRidingHood[3] + "\" Try again Red Riding Hood!";
        }
        else if(state == 5){
             if(input.equalsIgnoreCase(redRidingHood[4])){
                output = theWolf[4];
                state = 6;
            }
            else
                output = "You are supposed to say \"" + redRidingHood[4] + "\" Try again Red Riding Hood!";
        }
        else if(state == 6){
             if(input.equalsIgnoreCase(redRidingHood[5])){
                output = theWolf[5];
                state = 7;
            }
            else
                output = "You are supposed to say \"" + redRidingHood[5] + "\" Try again Red Riding Hood!";
        }
        else if(state == 7){
             if(input.equalsIgnoreCase(redRidingHood[6])){
                output = theWolf[6];
                state = 8;
            }
            else
                output = "You are supposed to say \"" + redRidingHood[6] + "\" Try again Red Riding Hood!";
        }
        else if(state == 8){
             if(input.equalsIgnoreCase(redRidingHood[7])){
                output = theWolf[7];
                state = 9;
            }
            else
                output = "You are supposed to say \"" + redRidingHood[7] + "\" Try again Red Riding Hood!";
        }
        else if(state == 9){
            if(input.equalsIgnoreCase(redRidingHood[8])){
               output = theWolf[8];
               state = 10;
           }
           else
        	   output = "You are supposed to say \"" + redRidingHood[8] + "\" Try again Red Riding Hood!";
        }
        else if(state == 10){
             if(input.equalsIgnoreCase("y")){
                output = start;
                state = 1;
            }
             else{
                output = "BYE RED RIDING HOOD!";
                state  = WAITING;
             }
                 
        }
        else if(state == WAITING){
            output = start;
            state = 1;
        }
        

        return output;
    }
    
    
    
}

