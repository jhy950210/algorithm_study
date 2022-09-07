package src.PROGRAMMERS;

import java.util.*;
import java.util.stream.Stream;

public class kakao_open_chat {

    public static void main(String[] args) {
        String[] str = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        for(String result : solution(str)){
            System.out.println(result);
        }
        // result : ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
    }

    public static String[] solution(String[] record) {
        List<User> users = new ArrayList<>();
        Map<String, String> idToNickname = new HashMap<>();

        for (String row: record){
            String[] split = row.split(" ");

            String method = split[0];
            String userId = split[1];

            if( "Leave".equals(method) ){
                User user = new User(method, userId, idToNickname.get(userId));
                users.add(user);
            } else {
                String nickname = split[2];
                idToNickname.put(userId, nickname);
                users.stream().filter(user -> user.userId.equals(userId)).forEach(user -> user.changeNickname(nickname));

                if( "Enter".equals(method) ){
                    User user = new User(method, userId, nickname);
                    users.add(user);
                }
            }
        }

        String[] answer = new String[users.size()];
        for(int i=0; i< answer.length; i++){
            answer[i] = users.get(i).toLog();
        }

        return answer;
    }

    public static class User{
        private final String method;
        private final String userId;
        private String nickname;

        User(String method, String userId, String nickname){
            this.method = method;
            this.userId = userId;
            this.nickname = nickname;
        }

        private void changeNickname(String toNickname){
            this.nickname = toNickname;
        }

        private String toLog(){
            // Enter, Leave
            if("Enter".equals(method)){
                return nickname + "님이 들어왔습니다.";
            } else {
                return nickname + "님이 나갔습니다.";
            }
        }
    }

}
