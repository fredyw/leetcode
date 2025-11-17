// https://leetcode.com/problems/repeat-string/description/
interface String {
    replicate(times: number): string;
}

String.prototype.replicate = function(times): string {
    return this.repeat(times);
}
