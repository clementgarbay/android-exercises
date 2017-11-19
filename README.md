# Android exercises and code examples

> Technical support for Android course given at Mines Nantes

## Test

You should find the marked exercise in the `project` branch.

### Note

This project follows the bounded context pattern of Domain-Driven Design approach.
There are two bounded context :

- `book`, also containing the main activity `LibraryActivity`
- `generic` as a supporting subdomain, here mainly present for the UI stuff
 
 
Moreover, I tried to make generic the `BookListFragment` with a `ListFragment` (branch `generic`) but I quickly stopped the refactoring because we are limited for the types in the bundle for the fragment's argument. I would have liked to give to the generic ListFragment a callable function to fetch the related items, but it wasn't possible without make this function, or a service, parcelable (IMHO it is a bit weird to parcel a function, but maybe we don't have other choice to do that).
The best solution to avoid this limitation should be to have a dependency injection or a system like that.