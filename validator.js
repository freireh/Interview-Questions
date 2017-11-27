function isValid(expression) {
    var openClosePairMap = {};
    openClosePairMap['{'] = '}';
    openClosePairMap['['] = ']';
    openClosePairMap['('] = ')';

    var stack = [];

    for (var i = 0; i < expression.length; i++) {
        var c = expression.charAt(i);

        if (c in openClosePairMap) {
            stack.push(c);
        } else if (stack.length > 0 && (
                (c === openClosePairMap['{'] && stack[stack.length - 1] === '{') ||
                (c === openClosePairMap['['] && stack[stack.length - 1] === '[') ||
                (c === openClosePairMap['('] && stack[stack.length - 1] === '(') )) {
            stack.pop();
        } else if (stack.length === 0) {
            return false;
        }
    }

    return stack.length === 0;
}
