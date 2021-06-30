
public class test3 {
	/*
	CLI Flag Validator - 1
	Command Line Interface(CLI) 프로그램의 옵션을 부여하는 방법으로는 flag가 있습니다.

	1.png

	예를 들어, 'ls'는 디렉터리 내의 파일과 디렉터리를 화면에 출력하는 Linux의 기본 명령어입니다. 여기에 옵션으로 '-a'를 붙여 'ls -a'를 입력하는 것으로 숨겨진 파일을 포함해 디렉터리 내의 모든 파일과 디렉터리를 화면에 출력할 수 있습니다.
	이러한 flag들은 flag argument라는 인자를 받기도 합니다. 예를 들어 압축 명령어인 'tar'의 '-f'는 파일명을 인자로 받아야 합니다.
	이렇게 flag의 이름(flag_name)과, 각각의 flag가 받아야 하는 인자의 종류(flag_argument_type)를 묶어 놓은 것을 flag_rule이라고 정의합니다.

	당신은 LINE에 신입사원으로 입사하여 팀에서 동료들과 같이 일하고 있습니다.
	팀에서는 다수의 flag_rule을 가진 CLI 프로그램을 만드는 일을 진행하고 있습니다.
	당신은 프로그램을 실행하기 전에 주어진 명령어가 모든 flag_rule을 지키는지 검사하는 코드를 작성하는 업무를 할당받았습니다.
	당신이 작성한 코드는 팀 내에서 코드 리뷰를 진행할 예정입니다. 요구사항의 키워드를 의식하면서 코드를 작성하세요.

	program(프로그램 이름), flag_rule 배열 flag_rules, command(명령어) 배열 commands를 입력 받은 후, 각각의 command가 flag_rules를 지키는지 판별하는 코드를 작성하세요.

	요구사항
	읽기 편한 코드
	확장 가능한 코드
	의도를 설명하는 주석
	테스트가 용이한 코드
	주의사항
	모든 문제에서, CLI를 구현하기 위해 이미 만들어져 있는 library를 사용하는 것을 금지합니다.
	입력 형식
	program: string
	1 <= program의 길이 <= 10
	실행할 프로그램의 이름입니다.
	공백처리는 하지 않아도 됩니다.
	flag_rules: [flag_rule]
	1 <= flag_rules의 길이 <= 100
	flag_rule: "<flag_name> <flag_argument_type>"
	flag_name: string
	2 <= flag_name의 길이 <= 10
	flag_name은 '-'(dash)로 시작하고, 영어 대소문자로만 이루어져 있습니다.
	동일한 flag_name에 대한 처리는 하지 않아도 됩니다.
	flag_argument_type: "NULL" | "NUMBER" | "STRING"
	"NULL": flag argument를 받지 않습니다.
	"NUMBER": 0부터 9까지의 숫자로만 이루어진 flag argument를 받습니다.
	"STRING": 알파벳 대소문자로만 이루어진 flag argument를 받습니다.
	commands: [command]
	1 <= commands의 길이 <= 100
	1 <= command의 길이 <= 100
	command는 하나의 program과 여러 flag가 string 형태로 이어져 있고, 이들은 공백으로 구분됩니다.
	연속되는 공백도 공백처리를 하지 않아도 됩니다.
	출력 형식
	answer: boolean[]
	commands의 순서대로 각 command를 판단하여 boolean 배열을 반환합니다.
	command가 아래 조건을 모두 만족하면 True, 만족하지 않으면 False를 반환합니다.
	program으로 시작합니다.
	각 flag argument는 대응하는 flag의 flag_argument_type과 일치합니다.
	각 flag는 0번이나 1번 나타납니다.
	flag_rules에 존재하는 flag만 나타납니다.
	입출력 예제
	번호	program	flag_rules	commands	answer
	1	"line"	["-s STRING", "-n NUMBER", "-e NULL"]	["line -n 100 -s hi -e", "lien -s Bye"]	[True, False]
	2	"line"	["-s STRING", "-n NUMBER", "-e NULL"]	["line -s 123 -n HI", "line fun"]	[False, False]
	입출력 예제에 대한 해설
	[True, False]
	주어진 조건을 만족합니다.
	program 이름이 다릅니다.
	[False, False]
	flag "-s"는 "STRING", "-n"는 "NUMBER", flag_argument_type의 flag argument를 입력 값으로 받아야 합니다.
	대응하는 flag가 없는 flag argument가 존재합니다.
	*/
	/*
	  CLI Flag Validator - 2
주의사항: 본 문제는 1번 문제의 답안 코드를 기반으로 합니다. 만약 아직 1번 문제를 풀지 않았다면, 1번 문제를 먼저 풀어주세요.

flag_rules의 flag_argument_type이 추가됐습니다. 이제 2개 이상의 flag argument를 받는 경우를 고려해야 합니다. 그 외 조건은 1번 문제와 동일하며, 변경된 조건은 굵은 글씨로 강조되어 있습니다.

1번 문제의 답안을 수정해 새로운 요구사항을 처리하세요.

입력 형식
program: string
1 <= program의 길이 <= 10
실행할 프로그램의 이름입니다.
공백처리는 하지 않아도 됩니다.
flag_rules: [flag_rule]
1 <= flag_rules의 길이 <= 100
flag_rule: "<flag_name> <flag_argument_type>"
flag_name: string
2 <= flag_name의 길이 <= 10
flag_name은 '-'(dash)로 시작하고, 영어 대소문자로만 이루어져 있습니다.
동일한 flag_name에 대한 처리는 하지 않아도 됩니다.
flag_argument_type: "NULL" | "NUMBER" | "NUMBERS" | "STRING" | "STRINGS"
"NULL": flag argument를 받지 않습니다.
"NUMBER": 0부터 9까지의 숫자로만 이루어진 flag argument를 받습니다.
"NUMBERS": 1개 이상의 "NUMBER"로 이루어져 있습니다. 각 "NUMBER"는 공백으로 구분됩니다.
"STRING": 알파벳 대소문자로만 이루어진 flag argument를 받습니다.
"STRINGS": 1개 이상의 "STRING"으로 이루어져 있습니다. 각 "STRING"은 공백으로 구분됩니다.
commands: [command]
1 <= commands의 길이 <= 100
1 <= command의 길이 <= 100
command는 하나의 program과 여러 flag가 string 형태로 이어져 있고, 이들은 공백으로 구분됩니다.
연속되는 공백도 공백처리를 하지 않아도 됩니다.
출력 형식
answer: boolean[]
commands의 순서대로 각 command를 판단하여 boolean 배열을 반환합니다.
command가 아래 조건을 모두 만족하면 True, 만족하지 않으면 False를 반환합니다.
program으로 시작합니다.
각 flag argument는 대응하는 flag의 flag_argument_type과 일치합니다.
각 flag는 0번이나 1번 나타납니다.
flag_rules에 존재하는 flag만 나타납니다.
입출력 예제
번호	program	flag_rules	commands	answer
1	"line"	["-s STRINGS", "-n NUMBERS", "-e NULL"]	["line -n 100 102 -s hi -e", "line -n id pwd -n 100"]	[True, False]
2	"trip"	["-days NUMBERS", "-dest STRING"]	["trip -days 15 10 -dest Seoul Paris", "trip -days 10 -dest Seoul"]	[False, True]
입출력 예제에 대한 해설
[True, False]
주어진 조건을 만족합니다.
flag "-n"는 "NUMBERS"인 flag argument를 입력 값을 받아야 합니다.
[False, True]
flag "-dest"는 flag_argument_type이 "STRING"이므로 복수의 flag argument를 입력 값으로 받을 수 없습니다.
주어진 조건을 만족합니다.
	  
	 */
	/*
	 * CLI Flag Validator - 3
주의사항: 본 문제는 2번 문제의 답안 코드를 기반으로 합니다. 만약 아직 2번 문제를 풀지 않았다면, 2번 문제를 먼저 풀어주세요.

flag에는 별칭(alias)이 있는 경우가 있습니다. 예를 들어 압축 명령어인 'tar'의 '--help'와 '-h'는 모두 도움말을 나타내는 flag입니다.

이제 별칭을 지정하는 새로운 flag_rule을 처리해야 합니다. 그 외 조건은 2번 문제와 동일하며, 변경된 조건은 굵은 글씨로 강조되어 있습니다.

2번 문제의 답안을 수정해 새로운 요구사항을 처리하세요.

입력 형식
program: string
1 <= program의 길이 <= 10
실행할 프로그램의 이름입니다.
공백처리는 하지 않아도 됩니다.
flag_rules: [flag_rule]
1 <= flag_rules의 길이 <= 100
flag_rule: "<flag_name> <flag_argument_type>" | "<flag_name_1> ALIAS <flag_name_2>"
flag_name: string
2 <= flag_name의 길이 <= 10
flag_name은 '-'(dash)로 시작하고, 영어 대소문자로만 이루어져 있습니다.
동일한 flag_name에 대한 처리는 하지 않아도 됩니다.
flag_argument_type: "NULL" | "NUMBER" | "NUMBERS" | "STRING" | "STRINGS"
"NULL": flag argument를 받지 않습니다.
"NUMBER": 0부터 9까지의 숫자로만 이루어진 flag argument를 받습니다.
"NUMBERS": 1개 이상의 "NUMBER"로 이루어져 있습니다. 각 "NUMBER"는 공백으로 구분됩니다.
"STRING": 알파벳 대소문자로만 이루어진 flag argument를 받습니다.
"STRINGS": 1개 이상의 "STRING"으로 이루어져 있습니다. 각 "STRING"은 공백으로 구분됩니다.
ALIAS
flag_name_1은 flag_name_2의 ALIAS입니다. 따라서 flag_argument_type도 같고, flag_name_1과 flag_name_2는 동시에 입력할 수 없습니다.
원래 이름인 flag_name_2의 flag_argument_type을 정의한 flag_rule은 항상 flag_rules에 존재합니다.
ALIAS의 ALIAS는 존재하지 않습니다.
하나의 flag는 최대 하나의 ALIAS만 가집니다.
commands: [command]
1 <= commands의 길이 <= 100
1 <= command의 길이 <= 100
command는 하나의 program과 여러 flag가 string 형태로 이어져 있고, 이들은 공백으로 구분됩니다.
연속되는 공백도 공백처리를 하지 않아도 됩니다.
출력 형식
answer: boolean[]
commands의 순서대로 각 command를 판단하여 boolean 배열을 반환합니다.
command가 아래 조건을 모두 만족하면 True, 만족하지 않으면 False를 반환합니다.
program으로 시작합니다.
각 flag argument는 대응하는 flag의 flag_argument_type과 일치합니다.
각 flag는 0번이나 1번 나타납니다.
flag_rules에 존재하는 flag만 나타납니다.
입출력 예제
번호	program	flag_rules	commands	answer
1	"line"	["-s STRING", "-num NUMBER", "-e NULL", "-n ALIAS -num"]	["line -n 100 -s hi -e", "line -n 100 -e -num 150"]	[True, False]
2	"bank"	["-send STRING", "-a ALIAS -amount", "-amount NUMBERS"]	["bank -send abc -amount 500 200 -a 400", "bank -send abc -a hey"]	[False, False]
입출력 예제에 대한 해설
[True, False]
주어진 조건을 만족합니다.
flag의 원래 이름과 별칭이 동시에 등장합니다.
[False, False]
flag의 원래 이름과 별칭이 동시에 등장합니다.
flag "-a"는 "-amount"의 별칭이므로, "NUMBERS" flag argument를 입력 값으로 받아야 합니다.
solution.cpp
1
#include <string>
2
#include <vector>
3
​
4
using namespace std;
5
​
6
vector<bool> solution(string program, vector<string> flag_rules, vector<string> commands) {
7
    vector<bool> answer;
8
    return answer;
9
}
실행 결과
실행 결과가 여기에 표시됩니다.
종료까지

	 * 
	 * 
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
