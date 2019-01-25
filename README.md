# dailyCodingProblem
Coding excercies - Git merge conflict Resolve

Upstream changes could not be merged in automatically due to conflicts in the following file:

product-presentation-initial-load/src/main/java/com/jcpenney/dpr/productpresentation/batch/provider/EnsembleRestProvider.java

How to perform a manual merge:
Step 1: Fetch changes from the upstream repository (saving the upstream branch as FETCH_HEAD).


git fetch https://stash.jcpenney.com/scm/dpr/promotion-jobs.git develop
Step 2: Checkout the fork branch and merge in the changes from the upstream branch. Resolve conflicts.


git checkout develop 
git merge FETCH_HEAD

Step 3: After the merge conflicts are resolved, stage the changes accordingly, commit the changes and push.


git commit
git push https://stash.jcpenney.com/scm/~mshaik/promotion-jobs.git HEAD
