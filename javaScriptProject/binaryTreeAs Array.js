function whatBranchIsBigger(tree){
    // right: 6+9
    // left: 2+10
    
    // start and end  are indices of nodes on a level
    // since it's a binary tree, each level has double of nodes from the previous one
    var startIdxLevel = 1;
    var numElementsLevel = 2*startIdxLevel + 1;
    // number of elements on the level for each branch    
    var numElementsBranch = (numElementsLevel - startIdxLevel)/2;
    var leftTreeSum = 0;
    var rightTreeSum = 0;
    var missingNodeMarker = -1;    
    while (startIdxLevel < numElementsLevel) {    
        // process level
        for (var i = startIdxLevel; i < startIdxLevel + numElementsBranch; i++){   
            var leftNode = tree[i] == missingNodeMarker ? 0 : tree[i];
            leftTreeSum = leftTreeSum + leftNode;

            var rightNode = (tree[numElementsBranch+i] == missingNodeMarker || numElementsBranch+i >= tree.length) ? 0 : tree[numElementsBranch+i];
            rightTreeSum = rightTreeSum + rightNode;
        }
        startIdxLevel = numElementsLevel;
        //numElementsBranch = (2*start index + 1 - start index)/2    
        numElementsBranch = (startIdxLevel + 1)/2;
        numElementsLevel = 2*numElementsLevel > tree.length ? tree.length : 2*numElementsLevel+1;           
    }

    if ( leftTreeSum > rightTreeSum ) {
        return "left";
    }
    else if ( rightTreeSum > leftTreeSum ) {
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