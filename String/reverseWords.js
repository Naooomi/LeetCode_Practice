/**

  Description:

  Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

*/

/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    let arr = [];
    let word = '';
    for (let i = s.length -1; i >= 0; i--)
    {
      if (s[i] === ' ')
      {
        // The unshift() method adds one or more elements to the beginning of an array and returns the new length of the array.
        arr.unshift(word);
        word = '';
        continue;
      }
      word += s[i];
    }
    arr.unshift(word);
    // The join() method joins all elements of an array into a string and returns this string.
    return arr.join(' ');
};
