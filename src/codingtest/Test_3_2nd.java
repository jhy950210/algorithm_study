package src.codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Test_3_2nd {
	// int -> double : possible
    // double -> int : impossible

    // error condition
    // 1) Parameter 개수가 정의와 다를 때
    // 2) Parameter Type이 정의와 다를 때, Parameter 순서도 동일해야 한다.

    static boolean isSuccess;
    static Map<String, FunctionSpec> map;

public static String checkParams(String func, String retType, String[] params){
        if(!isSuccess) return map.get(func).retType;

        if(map.getOrDefault(func, null) == null) {      // Function이 없는 경우
            isSuccess = false;
            return map.get(func).retType;
        }

        FunctionSpec function = map.get(func);
        // System.out.println("Spec: " + function.func + ": " + Arrays.toString(function.params));

//         System.out.println(func + " " + Arrays.toString(params) + "/ " + params.length);
//         System.out.println(function.func + " " + Arrays.toString(function.params) + "/ " + function.params.length);
        if(function.params.length == 1 && function.params[0].equals("")) function.params = new String[0];    // 코테 이후 1줄 추가함.

        // 함수 파라미터 개수 검사
        if(function.params.length != params.length) {
            isSuccess = false;
            return function.retType;
        }
        // System.out.println(params);

        for(int i=0; i<params.length; i++){     // 각 Parameter 확인 및 Parameter Type 검사
            // System.out.println(params[i]);

            // Parameter가 Function 인지 확인 -> 재귀
            if(params[i].indexOf("(") != -1){
                // System.out.println("Function: " + params[i]);
                FunctionSpec ret = parsing(params[i]);
                String retTypeFromParam = checkParams(ret.func, ret.retType, ret.params);

                if(!retTypeFromParam.equals(function.params[i])) {       // 파라미터 타입 검사(현재 Function의 i번째 파라미터와 return 타입 일치여부)
                    isSuccess = false;
                    return function.retType;
                }

            }
            // Parameter가 string 인지 확인
            else if(params[i].indexOf("\"") != -1){
                // System.out.println("String: " + params[i]);
                if(!function.params[i].equals("string")){
                    isSuccess = false;
                    return function.retType;
                }
            }
            // Parameter가 double 형인지 확인
            else if(params[i].indexOf(".") != -1){
                // System.out.println("Double: " + params[i]);
                if(!function.params[i].equals("double")){
                    isSuccess = false;
                    return function.retType;
                }
            }
            // Parameter가 int 인지 확인: parameter == params[i]는 위에서 걸러져서 숫자임
            else if(!function.params[i].equals("int") && !function.params[i].equals("double")){
                isSuccess = false;
                return function.retType;
            }
        }

        return map.get(func).retType;
    }

        public static FunctionSpec parsing(String str){
        String tFunc = str.substring(0, str.indexOf("("));
        String tParamStr = str.substring(tFunc.length() +1 , str.length() - 1);
        String[] tParams = tParamStr.split(",");
        if(tParamStr.equals("")) tParams = new String[0];

        List<String> paramsList = new ArrayList<>();
        int openCnt = 0;
        String concatStr = "";

        for(int i=0; i<tParams.length; i++){
            String tmp = tParams[i];

            for(int j=0; j<tmp.length(); j++){
                if(tmp.charAt(j) == '(') openCnt++;
                else if(tmp.charAt(j) == ')') openCnt--;
            }

            concatStr = concatStr + tmp + ",";

            if(openCnt == 0){
                paramsList.add(concatStr.substring(0, concatStr.length() - 1));
                concatStr = "";
            }
        }
        String[] tParams2 = new String[paramsList.size()];
        for(int i=0; i<paramsList.size(); i++) tParams2[i] = paramsList.get(i);

        // System.out.println(Arrays.toString(tParams2) + " ??" + tParams2.length);

        return new FunctionSpec(tFunc, map.get(tFunc).retType, tParams2);
    };

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int F = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new HashMap<>();
        for(int i=0; i<F; i++){
            st = new StringTokenizer(br.readLine(), " ");

            String retType = st.nextToken();

            st = new StringTokenizer(st.nextToken(), "(");
            String func = st.nextToken();

            String paramStr = st.nextToken();
            String[] params = paramStr.substring(0, paramStr.length() - 1).split(",");
            if(paramStr.equals("")) params = new String[0];

            // System.out.println(func + " " + retType + " " + Arrays.toString(params));

            map.put(func, new FunctionSpec(func, retType, params));
        }

        int C = Integer.parseInt(br.readLine());

        for(int i=0; i<C; i++){
            // st = new StringTokenizer(br.readLine(), "(");
            // System.out.println(i + "-------------");

            String str = br.readLine();

            FunctionSpec function = parsing(str);

            isSuccess = true;
            // System.out.println(Arrays.toString(tParams));
            String ret = checkParams(function.func, function.retType, function.params);

            if(isSuccess) System.out.println(ret);
            else System.out.println("error");
        }


    }

    public static class FunctionSpec{
        String func;
        String retType;
        String[] params;

        FunctionSpec(){}

        FunctionSpec(String func, String retType, String[] params){
            this.func = func;
            this.retType = retType;
            this.params = Arrays.copyOf(params, params.length);
            // System.out.println(this.params.length);
            // System.out.println(params.length);
        }
    }
}


/*
1. 출퇴근 시간 주어지고 파싱해서 가장 인원 많을 때, 사무실 최대 인원 구하기 (출퇴근 시간까지 사무실에 인원이 포함된 것으로 간주)
4
11:00 15:00
12:15 23:59
05:24 11:00
22:01 22:05
--> 3

2. 사다리 타기 
사다리 입력 주어지고 각 라인의 사람들이 모두 사다리 탔을 때, 결과 값 배열 구하기

3. 프로그래밍 언어 문법 만들어서, error 체크 및 반환 값 확인하기 (int => double 형변환 가능 조건, {함수 파라미터 개수!와, 파라미터 타입 검사!})

3.문제 입력 예시
5
double f1(double)
string f2(double)
int f3(int,double)
string f4()
double f5(string)
8
f1(25.13)
f1("false")
f2(33.3333,f1(f1(-1.05)))
f2(f1(f1(f1(-1.05))))
f1(f5(f2(0.1)))
f3(0,0.1)
f4()
f4(0)

double
error
error
string
double
int
string
error


5
double f1(double)
string f2(double)
int f3(int,double)
string f4()
double f5(string)
1
f3(0,0.1)




*/