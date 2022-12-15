//스트링 처리 잘하는 지 확인하는 문제였음.

//스트링이 인풋으로 주어졌을 때, 그보다 앞 인덱스 중 가장 가까운 동일 글자 있는지 확인하고 떨어진 인덱스 거리만큼을 배열에 차례로 담아 아웃풋으로 뱉어줌.

class Solution {
    public int[] solution(String s) {
        int[] answer = {};        
        answer = new int[s.length()];//인풋으로 들어온 스트링 길이만큼 배열 초기화

        for(int i=0; i<s.length(); i++){//인풋 스트링 길이만큼 for문
            char c = s.charAt(i);//각각 한글자씩 해야하므로 char로
            String text = String.valueOf(c);// 다시 string으로

            String subText = s.substring(0,i);//해당 인덱스 이전까지 자른 새로운 서브 문자열(비교위해서)            

            if(subText.contains(text)) { //서브스트링에서 지금 해당하는 text를 포함하고있다면
                answer[i] =  i - (subText.lastIndexOf(text)); //서브스트링에서 lastIndexOf 로 가장 마지막 동일 문자열 인덱스 얻고, 떨어진 거리? 알기위해 현재 인덱스에서 빼기
            } else {//포함 안하면 바로 -1로 배열에 값 넣기
                answer[i] = -1;
            }
        }

        return answer;
    }
}



//구글링해서 참고한내용
//string.charAt(index)
//String.valueOf(char)
//string.lastIndexOf("string")
