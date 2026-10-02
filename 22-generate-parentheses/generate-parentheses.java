class Solution {
    class State {
        String currentString;
        int openCount;
        int closeCount;

        State(String currentString, int openCount, int closeCount) {
            this.currentString = currentString;
            this.openCount = openCount;
            this.closeCount = closeCount;
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Stack<State> stack = new Stack<>();

        stack.push(new State("", 0, 0));
        
        while (!stack.isEmpty()) {
            State state = stack.pop();
            
            if (state.currentString.length() == n * 2) {
                result.add(state.currentString);
                continue;
            }
            if (state.closeCount < state.openCount) {
                stack.push(new State(state.currentString + ")", state.openCount, state.closeCount + 1));
            }
            
            if (state.openCount < n) {
                stack.push(new State(state.currentString + "(", state.openCount + 1, state.closeCount));
            }
        }
        return result;
    }
}