function whatBranchIsBigger(tree){
    // right: 6+9
    // left: 2+10
    
    // start and end  are indices of nodes on a level
    // since it's a binary tree, each level has double of nodes from the previous one
    var start = 1;
    var end = 2*start + 1;
    var halfPoint = (end - start)/2;
    var left = 0;
    var right = 0;
    var missingNode = -1;    
    while (start < end) {    
        // process level
        for (var i = start; i < start + halfPoint; i++){   
            var leftNode = tree[i] == missingNode ? 0 : tree[i];
            left = left + leftNode;

            var rightNode = (tree[halfPoint+i] == missingNode || tree[halfPoint+i] == undefined) ? 0 : tree[halfPoint+i];
            right = right + rightNode;
        }
        start = end;    
        halfPoint = (start + 1)/2;
        end = 2*end > tree.length ? tree.length : 2*end+1;           
    }

    if ( left > right ) {
        return "left";
    }
    else if ( right > left ) {
        return "right";
    }
    else {
        return "equal";
    }
    
}

// missing node is represented by -1
// tree has the following structure:
// root: 3 --> [6,2]
// 6 --> [9,-1], 2 --> [10, ]
tree = [3,6,2,9,-1,10];
res = whatBranchIsBigger(tree);
console.log(res);

tree = [3,6,2,9,-1,10,-1,1,2,-1,-1,3,4];
res = whatBranchIsBigger(tree);
console.log(res);

tree = [];
res = whatBranchIsBigger(tree);
console.log(res);

tree = [1];
res = whatBranchIsBigger(tree);
console.log(res);