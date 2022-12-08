//문자열 배열이 주어질 때, 네가지 스트링을 한번씩 조합한 것만 카운트 가능한 경우 카운트한 개수 구하기.

//작성 코드
import java.util.Arrays;

class Solution {    
    public int solution(String[] babbling) {
        int answer = 0;
        
      //포함가능한 데이터 스트링 배열.
        String[] datas = new String[]{"aya", "ye", "woo", "ma"};        
        
        for (String babble : babbling) {           
           int c = 0; //포함된 데이터 개수 카운트
           int defense = 0;  //while 문 횟수(방어코드)            
            
            loop : while( babble.length() > 0 )
             {
                   
                for(String data : datas) {  //가능한 스트링이 포함되있는지 확인                  
                    if(babble.indexOf(data) == 0){  //처음문자열로 포함된 경우
                        babble = babble.replaceAll(data,"");  //빈 문자열로 없애고 카운트 업                             
                         c++;
                    } 
                }
                if(c == 0) break loop;//포함된게 하나도 없었으면 바로 while문 탈출
                if((c > 0) &&  (defense > 0)  && (babble.length() > 0)) { //포함된게 하나라도 있고, while문 한번이상 돌았는데 남은 문자열이 더 있는경우
                    c = 0; //다시 카운트 0으로 초기화, 다음 for문에서 포함된게 없으면 while문 탈출할거고 있으면 다시 카운트 업
                }
              
                 defense++; //while문 다 돌았으니까 디펜스 업
                
                if(defense > 15) break loop; //최대 가능한 문자 길이 15인데 그거 보다 while 문 많이 돌 경우는 탈출.
             }
            
            if(c > 0) answer++; // 탈출 했을 때 카운트가 하나라도 업 되어있으면 최종 개수 업
        }
        
        return answer;
    }
}




//다른 사람 풀이


정규식 관련 풀이있었는데 이건 정규식을 내가 외우고 있지 못해서 이해 못함.
참고하면 좋겠다 싶은 코드는 공통 문자로 치환하는 방법.

for (String babble : babbling) { //입력 파라미터 스트링 배열 돌면서
    babble = babble.replace("aya","1"); //포함 가능 문자들을 전부 하나의 공통 문자로 치환
    babble = babble.replace("woo","1");
    babble = babble.replace("ye","1");
    babble = babble.replace("ma","1");
    babble = babble.replace("1",""); //공통 치환된 문자를 마지막에 빈 문자열로 치환
    
    if(babble.length() == 0){ //빈 문자열이면 카운트 업
      answer++;
    }
}


이런식으로 코드 짜면 나중에 포함 가능 문자들을 하드코딩으로 손수 추가해줘야하는 번거로움이 있을 수 있으니,
그건 DB io 나 공통 변수로 빼서 관리하는 방법으로 보완하면 좋을 듯 하다.
일단 가독성이 좋은듯



