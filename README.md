# FamilyTree
A. Build a Family Tree
Design a command line system which can help a user define his family tree &amp; be able to fire a few
interesting queries.
Our command line tool (family-tree) can have the following options:
1. family-tree add person &lt;name&gt;
eg: family-tree add RAVI
2. family-tree add relationship &lt;name&gt;
eg: family-tree add relationship father
eg: family-tree add relationship son
3.family-tree connect &lt;name 1&gt; as &lt;relationship&gt; of &lt;name 2&gt;
eg: family-tree connect RAVI as son of ANKIT
B. Interesting Queries:
Few listed below.
1. family-tree count sons of &lt;name&gt;
This should return count of sons
2.family-tree count all daughters of &lt;name&gt;
This should return count of all daughters, including great grand daughters of name
