package AlgoExpret.Stack.ShortenPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class ShortenPath {

    /*
     * Problem: Write a function that in a non-empty string represinting a valid
     * unix-shell path and returns a shortened version of that path.
     * 
     * A path is a notation that represents the location of a file or directory in
     * a file system.
     * 
     * In a Unix-like operating system, a path is bound by the following rules:
     * - The root directory is represented by a /. This means that if a path starts
     *   /, it's an absolute path; if it doesn't, it's a relative path.
     * - The symbol / otherwise represents the directory seperator. This means that
     *   the path /foo/bar is the location of the directory bar inside the directory
     *   foo, which is itself located inside the root directory.
     * - The symbol .. represents the parent directory. This means that accessing
     *   files or directories in /foo/bar/.. is equivalent to accessing files or 
     *   directories in /foo.
     * - The symbol . represents the current directory. This means that accessing 
     *   file or directories in /foo/bar/. is equivalent to accessing files or
     *   directories in /foo/bar.
     * - The symbols / and . can be repeated sequentially without consequence; the
     *   symbol .. cannot, however, because repeating it sequentially means going 
     *   further up in parent directories. For example, /foo/bar/baz/././. and
     *   /foo/bar/baz are equivalent paths, but /foo/bar/baz/../../../ and
     *   /foo/bar/baz difinitely aren't. The only exception is with the root
     *   directory: /../../.. and / are equivalent, because the root directory has
     *   no parent directory, which means that repeatedly accessing parent directory
     *   does nothing.
     * 
     * Note that the shortened version of the path must be equivalent to the original
     * path. In other words, it must point to the same file or directory as the 
     * original path.
     */

    public static String shortenPath(String path) {
        // Write your code here;

        // this will be used to control the path before returned at the end of function
        Boolean absolutePath = path.charAt(0) == '/';

        // tokens are the path that inputted to function
        String [] tokens = path.split("/");

        // filteredTokens are tokens after removing useless tokens (using filterTokens method)
        List<String> filteredTokens = filterTokens(new ArrayList(Arrays.asList(tokens)));

        // stack will be used for storing the path will be returned (in opposite sorting)
        Stack<String> stack = new Stack();

        // looping all filtered tokens to chcking all in's and out's to and off directories
        for (String token : filteredTokens) {

            // the path is not absolute
            if (!absolutePath) {

                // to pop off the stack we need to make sure we had entered a directory before
                // (not ".." at the top of the stack) 
                if (!stack.empty() && token.equals("..") && !stack.peek().equals("..")) 
                    stack.pop();
                
                // otherwise (stack is empty, token ≠ ".." and even token = ".." 
                // but also the top of the stack is "..", which means it returns to directories up)
                else stack.push(token);
            
            // if the path is absolute
            } else if (absolutePath) {

                // Just we need to make sure that the token = ".." to pop off stack
                if (!stack.empty() && token.equals(".."))
                    stack.pop();
                
                // to push into stack we need to make sure that token ≠ ".."
                else if(!token.equals("..")) stack.push(token);
            }

        }

        // if the path entered to function was absolutes then we need to add / to 
        // the stack before return
        if (absolutePath) return '/' + String.join("/", stack);
        return String.join("/", stack);
    }

    // filterTokens method filters pathTokens list from all unneccesary 
    // tokens (mentioned in the question)
    public static List<String> filterTokens(ArrayList<String> pathTokens){

        // uselessTokens list used for storing tokens that needed to be removed from 
        // our main tokens list
        ArrayList<String> uselessTokens = new ArrayList();

        // adding all useless tokens that needed to be removed 
        uselessTokens.add(".");
        uselessTokens.add("");

        // remove all useless tokens from our main tokens list
        pathTokens.removeAll(uselessTokens);
        
        return pathTokens;
    }

    public static void main(String[] args) {

        ShortenPath sp = new ShortenPath();

        String path = "../../foo/..//bar/./baz";

        System.out.println(sp.shortenPath(path));
    }
}
