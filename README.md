A GitHub search tool which uses GitHub's search API to search provided repositories for a provided keyword. I created 
this service to get around the GitHub limitation of not being able to search for words in code across a team's repos.
Searching across the entire organisation I am interested in yields top many results for me to check through them to find 
out if my repositories are affected.

**Good points**
1. You don't need to clone a repo to search it and don't need to go on the GitHub website
2. You can generate a PAT (Personal Access Token) which allows you to search the private repositories you have access to

**Bad points**
1. Rate limiting. 30 requests (per minute?). If I'd have read about this first I'd have written the logic differently so a
single search request is sent for an organisation rather than by repo and then I'd have filtered the results on the interesting repos
2. Search only matches on whole words, not partial matches. GitHub doesn't support wildcard search 😕
3. Code is messy and doesn't follow MVC at the moment
   
**Potential improvements**
1. Make a single request for a search to avoid being rate limited and having to wait between requests
2. Add partial word search so that matches aren't just on whole words 