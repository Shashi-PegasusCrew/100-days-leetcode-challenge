class Solution {
    private void dfs(int[][] image, int i, int j, int originalColor, int newColor) {
        
        if (i<0|| i >= image.length ||j<0|| j >= image[0].length || image[i][j] != originalColor)
            return;

        image[i][j] = newColor;

        dfs(image, i + 1, j, originalColor, newColor); 
        dfs(image, i - 1, j, originalColor, newColor); 
        dfs(image, i, j + 1, originalColor, newColor); 
        dfs(image, i, j - 1, originalColor, newColor); 
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int originalColor=image[sr][sc];
        if(color==originalColor){
            return image;
        }
         dfs(image, sr, sc, originalColor, color);
        return image;
    }
}













