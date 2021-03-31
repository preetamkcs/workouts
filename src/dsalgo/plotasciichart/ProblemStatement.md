# Problem Statement
## Time Series chart

### Statement:
<p>Write a program to generate time series like chart with the help of given input integers as an array. The array is going to containing only positive non-zero integers. The integers placed in odd indices of a 0-indexed array represents decline and the even placed integers represents incline </p>

#### Example 1

##### input:
`[1, 3, 3, 5]`

##### output:
```
/\    /\    
  \  /  \   
   \/    \  
          \ 
           \
```

#### Example 2

##### input:
`[1,2,1,2,3,1,2,3,1,2]`

##### output:
```
           /\     
/\      /\/  \    
  \/\  /      \/\ 
     \/          \
```
### Contraints:
- The integers > 0