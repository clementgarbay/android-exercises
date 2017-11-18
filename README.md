# Android exercises and code examples

> Technical support for Android course given at Mines Nantes

## Test

You should find the marked exercise in the `project` branch.

### Note

This project follows the bounded context pattern of Domain-Driven Design approach.
There are two bounded context :

- `book`, also containing the main activity `LibraryActivity`
- `generic` as a supporting subdomain, here mainly present for the UI stuff
 
 
Moreover, I tried to make generic the `BookListFragment` with a `ListFragment` (branch `generic`) but I quickly stopped the refactoring because we are limited for the types in the bundle for the fragment's argument. I would have like to give to the generic ListFragment a callable function to fetch the related items, but it wasn't possible without make this function parcelable (IMHO it is a bit weird to parcel a function).
Maybe, the best solution to avoid this limitation is to have a dependency injection or a system like that.