public class SearchMatrix{
    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix==null||matrix.length<1) return false;
        return searchHelper(matrix, target, 0,0,matrix.length, matrix[0].length);   
    }
    
    public boolean searchHelper(int[][] matrix, int target, int begin_row, int begin_col, int end_row, int end_col){
        int begin_order=begin_row*matrix[0].length+begin_col;
        int end_order=end_row*matrix[0].length+end_col;
        if(begin_order>end_order) return false;
        if(begin_order==end_order) return (matrix[begin_row][begin_col]==target);
        int mid_order=(begin_order+end_order)/2;
        int mid_row=mid_order/matrix[0].length;
        int mid_col=mid_order%matrix[0].length;
        if(matrix[mid_row][mid_col]<target) {
            int next_order=mid_order+1;
            int next_row=next_order/matrix[0].length;
            int next_col=next_order%matrix[0].length;
            return searchHelper(matrix, target, next_row,next_col, end_row, end_col);
        }else if(matrix[mid_row][mid_col]>target){
            int next_order=mid_order-1;
            int next_row=next_order/matrix[0].length;
            int next_col=next_order%matrix[0].length;
            return searchHelper(matrix, target,begin_row, begin_col, next_row,next_col);
        }else return true;
    }

}